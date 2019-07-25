package com.ranx.chowder.netty.fromBlog.bg2serverAndClient;

import java.text.SimpleDateFormat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Description
 * @author ranx
 * @date 2018年10月31日 下午2:59:06
 *
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String>{


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress());
        System.out.println(msg);
        ctx.channel().writeAndFlush("to Server: AAAAA");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.print(timeFormat() + "........");
        ctx.channel().writeAndFlush("来自客户端的问候！");
        System.out.println("client channel active...");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.print(timeFormat() + "........");
        System.out.println("client handler added...");
    }


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.print(timeFormat() + "........");
        System.out.println("client channel register...");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.print(timeFormat() + "........");
        System.out.println("client channel inactive...");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.print(timeFormat() + "........");
        System.out.println("client channel unregister...");
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    public String timeFormat() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = dateformat.format(System.currentTimeMillis());
        return dateStr;
    }
}
