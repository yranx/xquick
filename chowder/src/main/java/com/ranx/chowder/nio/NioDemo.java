package com.ranx.chowder.nio;

import org.apache.tomcat.util.buf.ByteBufferUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * @author ranx
 * @create 2019-01-03 15:46
 **/
public class NioDemo {
    private static String FROM_PATH = "F:\\logs\\info.log";
    private static String TO_PATH = "F:\\logs\\test\\infoNIO.log";
    //非直接缓冲区
    public static void notDirectBuffer() {
        try {
            FileInputStream fis = new FileInputStream(FROM_PATH);
            FileOutputStream fos = new FileOutputStream(TO_PATH);

            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (inChannel.read(buffer) != -1) {
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
            }

            outChannel.close();
            inChannel.close();
            fos.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //直接缓冲区
    public static void directBuffer() {
        try {
            FileChannel inChannel = FileChannel.open(Paths.get(FROM_PATH), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get(TO_PATH), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            //内存映射文件
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //直接对缓冲区进行数据的读写操作
            byte[] bytes = new byte[inMappedBuf.limit()];
            inMappedBuf.get(bytes);
            outMappedBuf.put(bytes);

            outChannel.close();
            inChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //字符集: Charset
    /**
     *  编码： 字符串->字节数组
     *  解码： 字节数组->字符串
     */
    public static void printCharset(){
        Map<String, Charset> map = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> set = map.entrySet();

        for (Map.Entry<String, Charset> entry : set) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    public static void charsetCode(){
        Charset cst = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = cst.newEncoder();
        //获取解码器
        CharsetDecoder cd = cst.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("字符集");
        cBuf.flip();

        try {
             //编码
            ByteBuffer bBuf = ce.encode(cBuf);
            while (bBuf.hasRemaining()) {
                System.out.println(bBuf.get());
            }
            //解码
            bBuf.flip();
            CharBuffer cBuffer = cd.decode(bBuf);
            System.out.println(cBuffer.toString());

        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
    }

    //阻塞式--客户端
    public static void blockingClient() {
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8999));
            FileChannel inChannel = FileChannel.open(Paths.get(FROM_PATH), StandardOpenOption.READ);
            ByteBuffer buf = ByteBuffer.allocate(1024);

            while(inChannel.read(buf) != -1) {
                buf.flip();
                socketChannel.write(buf);
                buf.clear();
            }

            //接收服务端的反馈
            int len = 0;
            while ((len = socketChannel.read(buf)) != -1) {
                buf.flip();
                System.out.println(new String(buf.array(), 0, len));
                buf.clear();
            }
            inChannel.close();;
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void blockingServer() {
        try {
            ServerSocketChannel sSocketChannel = ServerSocketChannel.open();
            sSocketChannel.bind(new InetSocketAddress(8999));

            FileChannel outChannel = FileChannel.open(Paths.get(TO_PATH), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            SocketChannel socketChannel = sSocketChannel.accept();

            ByteBuffer buf = ByteBuffer.allocate(1024);
            while(socketChannel.read(buf) != -1) {
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }

            //发送反馈给客户端
            buf.put("服务端接收数据成功".getBytes());
            buf.flip();
            socketChannel.write(buf);

            socketChannel.close();
            outChannel.close();
            sSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //非阻塞式
    public static void noBlockingClient() {
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8999));

            //切换非阻塞模式
            socketChannel.configureBlocking(false);
            ByteBuffer buf = ByteBuffer.allocate(1024);

            Scanner scan = new Scanner(System.in);
            while (scan.hasNext()) {
                String str = scan.next();
                buf.put((new Date().toString() + "\n" + str).getBytes());
                buf.flip();
                socketChannel.write(buf);
                buf.clear();
            }

            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void noBlockingServer() {
        try {
            //1.获取通道
            ServerSocketChannel sSocketChannel = ServerSocketChannel.open();
            //2.切换非阻塞模式
            sSocketChannel.configureBlocking(false);
            //3.绑定连接
            sSocketChannel.bind(new InetSocketAddress(8999));

            //4.获取选择器
            Selector selector = Selector.open();
            //5.将通道注册到选择器上，并且指定"监听接收事件"
            sSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //6.轮询式的获取选择器上已经"准备就绪"的时间
            while (selector.select() > 0) {
                //7.获取当前选择器中所有注册的"选择键（已就绪的监听事件）"
                Set selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectedKeys.iterator();
                //循环遍历已选择键集中的每个键，并检测各个键所对应的通道的就绪事件。
                while (it.hasNext()) {
                    //8.获取准备"就绪"的是事件
                    SelectionKey selectionKey = it.next();

                    //9.判断具体是什么事件准备就绪
                    if (selectionKey.isAcceptable()) {
                        //10.若"接收就绪",获取客户端连接
                        SocketChannel socketChannel = sSocketChannel.accept();
                        //11.切换非阻塞模式
                        socketChannel.configureBlocking(false);
                        //12.将该通道注册到选择器上
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if(selectionKey.isReadable()) {
                        //13.获取当前选择器上“该就绪”状态的通道
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                        //14.读取数据
                        ByteBuffer buf = ByteBuffer.allocate(1024);

                        int len = 0;
                        while ((len = socketChannel.read(buf)) > 0 ) {
                            buf.flip();
                            System.out.println(new String(buf.array(), 0, len));
                            buf.clear();
                        }
                    }
                    //15. 取消选择键 SelectionKey
                    it.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        notDirectBuffer();
//        directBuffer();
//        printCharset();
//        charsetCode();
//        blockingServer();
//        blockingClient();
//        noBlockingServer();
        noBlockingClient();
    }
}
