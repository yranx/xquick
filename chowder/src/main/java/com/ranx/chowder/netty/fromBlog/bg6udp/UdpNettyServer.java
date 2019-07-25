package com.ranx.chowder.netty.fromBlog.bg6udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @Description 启动类
 * @author ranx
 * @date 2018年11月1日 下午2:14:50
 * UDP通信双方不需要建立链路
由于使用UDP通信，在创建Channel的时候通过NioDatagramChannel来创建，随后设置Socket参数支持广播，
最后设置处理handler.
相比于TCP通信，UDP不存在客户端和服务器端的实际连接，因此不需要为连接（channelPipeline）设置handler,
对于服务端，只需设置启动辅助类的handler即可。
 */
public class UdpNettyServer {
    public static void main(String[] args) throws Exception {
        EventLoopGroup elGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(elGroup).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true) //支持广播
                    .handler(new UdpNettyServerHandler());
            ChannelFuture chanelFuture = b.bind(8999).sync();
            chanelFuture.channel().closeFuture().await();
        } finally {
            // TODO: handle finally clause
        }
    }
}