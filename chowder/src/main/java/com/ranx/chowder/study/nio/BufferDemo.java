package com.ranx.chowder.study.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description  Buffer的操作
 * @author ranx
 * @date 2018年12月25日 上午11:05:43
 *
 */
public class BufferDemo {
	
	//基础操作
	public static void bufferBase() {
		IntBuffer buffer = IntBuffer.allocate(8);
		for (int i=0; i<buffer.capacity(); ++i) {
			buffer.put(i*i);
		}
		
		buffer.flip();
		while (buffer.hasRemaining()) {
			System.out.print(buffer.get() + " ");
		}
		
	}
	
	//分片
	public static void bufferSlice() {
		ByteBuffer buf = ByteBuffer.allocate(10);
		// 缓冲区中的数据0-9  
        for (int i=0; i<buf.capacity(); i++) {  
        	buf.put( (byte)i );  
        }
        
        //创建子缓冲区
        buf.position(3);
        buf.limit(7);
        ByteBuffer slice = buf.slice();
        
        //改变子缓冲区的内容 从buf第四位开始到第七位
        for (int i=0; i<slice.capacity(); i++) {
        	byte b = slice.get(i);
        	b *= 10;
        	slice.put(i, b);
        }
        
        buf.position(0);
        buf.limit(buf.capacity());
        
        while(buf.remaining() > 0) {
        	System.out.println( buf.get());
        }
	}
	
	//分配
	public static void  bufferWrap() {
		//分配指定大小 的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(10);
		
		//包装一个现有数组
		byte array[] = new byte[10];
		ByteBuffer buf = ByteBuffer.wrap(array);
	}
	
	
	//直接缓冲区
	public static void directBuffer() {
		String path = "F:\\logs\\data.txt";
		String toPath = "F:\\logs\\datas.txt";
		FileInputStream fis;
		FileOutputStream fos;
		try {
			fis = new FileInputStream(path);
			FileChannel fcl = fis.getChannel();
			
			fos = new FileOutputStream(toPath);
			FileChannel fco = fos.getChannel();
			
			/// 使用allocateDirect（方法直接调用底层C语言方法）
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
			
			while (true) {
				buffer.clear();
				
				int r = fcl.read(buffer);
				if (r==1) {
					break;
				}
				buffer.flip();
				fco.write(buffer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//缓存区映射
	public static void MappedBuffer() {
		final int start = 0;
		final int size = 1024;
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile("F:\\logs\\data.txt", "rw");
			FileChannel fc = raf.getChannel();
			
			//从缓冲区跟文件系统进行一个映射关联
			//只要操作缓冲区在里面的内容，文件内容也会跟着改变
			MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, start, size);
			mbb.put(0, (byte)97);
			mbb.put(3, (byte)97);
			mbb.put(1023, (byte)122);
			
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	//缓存区只读
	public static void readOnlyBuffer() {
		ByteBuffer buffer = ByteBuffer.allocate(10);
		for (int i=0; i<buffer.capacity(); i++) {  
			buffer.put( (byte)i );  
        }
		
		//创建只读缓冲区
		ByteBuffer readOnly = buffer.asReadOnlyBuffer();
		//改变原缓冲区内容，
        for (int i=0; i<readOnly.capacity(); i++) {
            byte b= buffer.get(i);
            b *= 10;
            buffer.put(i, b); //readOnly.put(i, b); 报错
        }
		readOnly.position(0);
		readOnly.limit(buffer.capacity());
		
		//只读缓冲区的内容也随之改变
		while(readOnly.remaining() > 0) {
			System.out.println(readOnly.get());
		}
	}
	
	public static void main(String[] args) {
//		bufferBase();
//		bufferSlice();
//		directBuffer();
//		MappedBuffer();
		readOnlyBuffer();
	}
}
