package com.ranx.chowder.study.netty.fromBlog.bg3chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Description 服务端Handler处理代码
 * @author ranx
 * @date 2018年10月31日 下午3:40:47
 *
 */
public class ChatServerHandler extends SimpleChannelInboundHandler<String>{

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channelGroup.size());
        channelGroup.forEach(c -> {
            if (channel == c) { //自己
                channel.writeAndFlush("【自己】:" + msg + "\n");
            } else { //发送给其他人
                c.writeAndFlush(channel.remoteAddress() + ": " + msg + "\n");
            }
        });
    }

    //连接断开
    public void handlerRemove(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("【服务器】: " + channel.remoteAddress() + "下线了\n");
    }

    //连接激活
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "上线了");
    }

    //连接断开
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "下线了");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
