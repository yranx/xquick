package com.ranx.chowder.study.netty.fromBlog.bg5websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @Description 服务端启动程序
 * 启动后，打开Socket.html网页即可
 * @author ranx
 * @date 2018年11月1日09:15:54
 * Netty对WebSocket的支持
 *　在Http1.0和Http1.1协议中，我们要实现服务端主动的发送消息到网页或者APP上，是比较困难的，尤其是现在IM(即时通信)几乎是很多APP都需要实现的功能，
 *我们往往采用一种轮询的方式让终端去请求服务器获取对应的数据，其实大多数的轮询都是无效的(即没有获得到任何的数据)；
 *另外一个方面，每一次轮询都是一个完整的Http请求，而根据Http协议，每一次请求都要在Header中携带大量的参数，这无疑对带宽也是一种极大的消耗。
　　html5的诞生为我们带来的WebSocket，WebSocket是基于Http协议的一种长连接协议，有了这种协议，就可以实现服务端主动往客户端发送消息的功能。
 */
public class WebsocketServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO)) //handler()主要针对bossGroup的处理
                    .childHandler(new WebSocketChannelInitializer()); //childHandler()主要是针对workerGroup的处理
            ChannelFuture channefuture = serverBootstrap.bind(8999).sync();
            channefuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
