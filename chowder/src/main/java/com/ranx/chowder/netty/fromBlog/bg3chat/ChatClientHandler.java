package com.ranx.chowder.netty.fromBlog.bg3chat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Description 客户端Handler代码
 * @author ranx
 * @date 2018年10月31日 下午4:35:51
 *
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<String>{


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);

    }

}
