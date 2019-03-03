package com.ranx.chowder.study.netty.fromBlog.bg1hello;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @Description  通道初始化程序
 * 主要是为workerGroup添加各种Handler
 * @author ranx
 * @date 2018年10月31日 上午10:09:56
 *
 */
public class TestChannelnitializer extends ChannelInitializer<SocketChannel>{


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // TODO Auto-generated method stub
        ChannelPipeline pipeline = ch.pipeline();
        /**
         * Handler相当于Servlet中的过滤器，请求和响应都会走Handler
         * HttpServerCodec ： http的编解码器，用于Http请求和响应
         */
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        pipeline.addLast("testHttpServerHandler", new TestHttpServerHandler());
    }

}