package com.ranx.chowder.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description 时钟服务器
 * @author ranx
 * @date 2018年12月24日 上午11:11:17
 *
 */
public class NioClockServer {

	public static Selector init() {
		try {
			// 创建通道，并设置非阻塞
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);

			// 创建选择器并为通道绑定感兴趣的事件
			Selector selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT).attach("主监听通道");
			System.out.println("监听的Channel Id: " + serverSocketChannel.hashCode());

			// 通道绑定端口号
			InetSocketAddress inetSockAddress = new InetSocketAddress("127.0.0.1", 4700);
			serverSocketChannel.socket().bind(inetSockAddress);
			return selector;
		} catch (ClosedChannelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void listenner(Selector selector, char name) {
		try {
			// 开始轮询通道事件
			while (true) {
				// 可以是阻塞，非阻塞，也可以设置超时
				int readyChannels = selector.selectNow();
				if (readyChannels > 0) {
					Set<SelectionKey> readyKeys = selector.selectedKeys();
					Iterator iterator = readyKeys.iterator();
					while (iterator.hasNext()) {
						SelectionKey readyKey = (SelectionKey) iterator.next();
						 // 必须removed 否则会继续存在，下一次循环还会进来,
	                    // 注意removed 的位置，针对一个.next() remove一次
						iterator.remove();
						//判断是哪个事件
						if (readyKey.isAcceptable()) {
							ServerSocketChannel readyChannel = (ServerSocketChannel) readyKey.channel();
							System.out.println("可接受连接的channel Id:" + readyChannel.hashCode() + readyKey.attachment());
							//设置非阻塞模式（必须），同时需要注册 读写数据的事件，这样有消息触发时才能捕获
							SocketChannel socketChannel = (SocketChannel) readyChannel.accept()
									.configureBlocking(false);
							System.out.println("接受连接后返回的channel Id" + socketChannel.hashCode());
							socketChannel.register(selector, (SelectionKey.OP_READ | SelectionKey.OP_WRITE))
									.attach(name);
							name++;
						}

						if (readyKey.isWritable()) { //写数据
							SocketChannel readyChannel = (SocketChannel) readyKey.channel();
							ByteBuffer buffer = ByteBuffer.allocate(512);
							buffer.put(("to " + readyKey.attachment() + " "
									+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n")
											.getBytes());
							buffer.flip();
							readyChannel.write(buffer);
						}

						if (readyKey.isReadable()) { //读数据
							SocketChannel readyChannel = (SocketChannel) readyKey.channel();
							ByteBuffer buffer = ByteBuffer.allocate(512);
							readyChannel.read(buffer);
							System.out.println(readyKey.attachment() + " " + getString(buffer));
						}
					}
				}
				Thread.sleep(1000);
			}
		} catch (ClosedChannelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getString(ByteBuffer buffer) {
		String str = "";
		try {
			for (int i = 0; i < buffer.position(); i++) {
				str += (char) buffer.get(i);
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static void main(String[] args) throws Exception {
		char name = 'A';
		listenner(init(), name);
	}
}
