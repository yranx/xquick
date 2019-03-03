package com.ranx.chowder.study.netty.tutorial;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *传统socket服务端
 * @author ranx
 * @create 2018-10-29 23:27
 * 单线程情况下只能有一个客户端
用线程池可以有多个客户端连接，但是非常消耗性能
 **/
public class OioServer {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        /**
         * 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，
         * 这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。 说明：Executors各个方法的弊端：
         1）newFixedThreadPool和newSingleThreadExecutor:
           主要问题是堆积的请求处理队列可能会耗费非常大的内存，甚至OOM。
         2）newCachedThreadPool和newScheduledThreadPool:
           主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程，甚至OOM。
         */
        // TODO
        //创建一个线程池
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        //创建socket服务，监听10101端口
        ServerSocket server = new ServerSocket(10101);
        System.out.println("服务端启动!");
        while (true) {
            //获取一个套接字（阻塞）
            final Socket socket = server.accept();
            System.out.println("来了一个新客户端！");
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //业务处理
                    handler(socket);
                }
            });

        }
    }

    /**
     * 读取数据
     * @param socket
     */
    public static void handler(Socket socket) {
        try {
            byte[] bytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (true) {
                //读取数据
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("socket关闭");
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
