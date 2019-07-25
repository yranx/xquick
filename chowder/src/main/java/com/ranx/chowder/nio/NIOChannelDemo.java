package com.ranx.chowder.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description 
 * @author ranx
 * @date 2018年12月24日 上午10:16:07
 *
 */
public class NIOChannelDemo {
	
	public static void ChannelBufToServe() throws Exception {
		String path = "F:\\logs" + File.separator + "data.txt";
		//创建从中读取和向其中写入（可选）的随机访问文件流，该文件具有指定名称
		RandomAccessFile aFile = new RandomAccessFile(path, "rw");

		FileChannel channel = aFile.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(128);
		int readByteLen;
		while ((readByteLen = channel.read(buffer)) != -1) {
			System.out.println("读取到buffer中的数据长度为："+readByteLen);
			//切换写模式到读模式
			buffer.flip();
			while (buffer.hasRemaining()) {
				System.out.print((char)(buffer.get()));
			}
			buffer.clear();//清除Buffer中的内容
			System.out.println();
		}
		aFile.close();
	}
	
	public static void clientBufToChannel() {
		//开辟一段buffer空间
        int cap = 10;
        IntBuffer buffer = IntBuffer.allocate(cap);
        //往buffer中添加数据
        for (int i=0; i<cap; i++) {
        	buffer.put(i*i);
        }
        
        
        System.out.println("buffer中的内容如下：");
        buffer.flip();
		while (buffer.hasRemaining()) {
			System.out.print(buffer.get());
		}
		buffer.clear();//清除Buffer中的内容
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		clientBufToChannel();
//		ChannelBufToServe();
	}
}
