package com.ranx.chowder.netty.fromBlog.bg4heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @Description 自定义Handler
 * @author ranx
 * @date 2018年10月31日17:12:46
 *
 */
public class MyHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception{
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;

            String idleType = null;
            switch(event.state()) {
                case READER_IDLE:
                    idleType = "读空闲";
                    break;
                case WRITER_IDLE:
                    idleType = "写空闲";
                    break;
                case ALL_IDLE:
                    idleType = "读写空闲";
                    break;
                default:;
            }

            System.out.println(ctx.channel().remoteAddress() + " " + idleType);
            ctx.channel().close();
        }
    }
}

