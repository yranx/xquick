package com.ranx.chowder.netty.fromBlog.bg4heartbeat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @Description 服务端启动程序
 * @author ranx
 * @date 2018年10月31日16:58:37
 *心跳检测技术
 *是一种检测端到端连接状态的技术。举例：现有A、B两端已经互相连接，但是他们之间很长时间没有数据交互，那么A与B如何判断这个连接是否可用呢？
 *通常的做法就是，让任何一方，例如让A端，定时的发送(例如每5秒钟)一句问候，如果B回复，
 *A收到了来自B的信息，也不在乎B到底给我回了什么，即可以断定与B的连接并没有断开；如果没有收到来自B的任何回复，过段时间再去发送问候，
 *那么我们通常认为连续3次问候，都没有收到来自B的恢复，即认为A与B之间的连接已经断开。那么就得尝试着重新获取一个新的连接。
 */
public class MyServer {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO)) //handler()主要针对bossGroup的处理
                    .childHandler(new MyInitializer()); //childHandler()主要是针对workerGroup的处理
            ChannelFuture channefuture = serverBootstrap.bind(8999).sync();
            channefuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

