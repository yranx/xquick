package com.ranx.chowder.study.netty.fromBlog.bg4heartbeat;

import java.util.concurrent.TimeUnit;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

/**
 * @Description 服务端通道初始化
 * @author ranx
 * @date 2018年10月31日17:10:46
 *
 */
public class MyInitializer extends ChannelInitializer<SocketChannel>{


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        /**
         * IdleStateHandler: 空闲状态处理器
         * 四个参数：读空闲、写空闲、读写空闲、时间单位
         * 空闲是指多长时间没有发生过响应的时间，就触发调用
         */
        pipeline.addLast(new IdleStateHandler(5, 7, 3, TimeUnit.SECONDS));
        //自定义的Handler
        pipeline.addLast(new MyHandler());
    }

}
