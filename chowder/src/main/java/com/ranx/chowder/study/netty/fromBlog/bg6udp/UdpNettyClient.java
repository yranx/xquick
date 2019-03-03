package com.ranx.chowder.study.netty.fromBlog.bg6udp;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;

/**
 * @Description 客户端
 * @author ranx
 * @date 2018年11月1日 下午3:39:18
 *UDP客户端会主动构造请求消息，向本网段内的所有主机请求消息，对于服务端而言接收到广播消息之后向广播消息的发起方进行定点发送。
 */
public class UdpNettyClient {

    /**
     * 创建UDPChannel和设置支持广播属性等与服务端完全一致，由于不需要和服务端建立链路，
     * UDP Channel 创建完成之后，客户端就要主动发送广播消息。
     * 而TCP客户端是在客户端和服务端链路建立成功之后由客户端的业务handler发送消息
     * @param args
     * @throws Exception
     */
    public static void main(String [] args) throws Exception{
        EventLoopGroup elGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(elGroup).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true) //允许广播
                    .handler(new UdpNettyClientHandler());
            Channel ch = b.bind(0).sync().channel();
            //向网段内的所有机器广播UDP消息
            ch.writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer("查询", CharsetUtil.UTF_8),
                    new InetSocketAddress("255.255.255.255", 8999))).sync();
            if (!ch.closeFuture().await(15000)) {
                System.out.println("查询超时！");
            }
        } finally {
            elGroup.shutdownGracefully();
        }
    }
}