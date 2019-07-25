package com.ranx.chowder.netty.fromBlog.bg6udp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

/**
 * @Description
 * @author ranx
 * @date 2018年11月1日 下午3:53:19
 *
 */
public class UdpNettyClientHandler extends SimpleChannelInboundHandler<DatagramPacket>{


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        String response = msg.content().toString(CharsetUtil.UTF_8);
        if (response.startsWith("查询结果：")) {
            System.out.println(response);
            ctx.close();
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}