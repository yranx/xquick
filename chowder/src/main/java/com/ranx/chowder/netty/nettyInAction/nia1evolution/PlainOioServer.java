package com.ranx.chowder.netty.nettyInAction.nia1evolution;


import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @Description 未使用Netty的阻塞网络编程
 * @author ranx
 * @date 2018年11月2日 上午10:12:53
 * 可以处理中等数量的并发客户端
 */
public class PlainOioServer {
    public void serve(int port) throws IOException {
        //将服务器绑定到指定端口
        final ServerSocket socket = new ServerSocket(port);
        try {
            for (;;) {
                //接受连接
                final Socket clientSocket = socket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                //创建一个新的线程来处理该连接
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            out = clientSocket.getOutputStream();
                            //将消息写给已连接的客户端
                            out.write("Hi\r\n".getBytes(
                                    Charset.forName("UTF-8")));
                            out.flush();
                            clientSocket.close();
                        } catch (Exception e) {
                            // TODO: handle exception
                        } finally {
                            try {
                                clientSocket.close();
                            } catch (Exception e2) {
                                // TODO: handle exception
                            }
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
