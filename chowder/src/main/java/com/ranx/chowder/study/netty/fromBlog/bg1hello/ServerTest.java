package com.ranx.chowder.study.netty.fromBlog.bg1hello;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Description Netty的启动服务程序
 * @author ranx
 * @date 2018年10月31日 上午9:49:17
 *
 */

public class ServerTest {

    public static void main(String[] args) throws InterruptedException {
        //创建父事件循环组,只负责连接，获取到连接后交给workergroup子事件循环组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //创建子类的事件循环组，参数的获取和业务处理等工作均由该子事件循环组完成
        //一个事件循环组 可以完成所有的工作，但是Netty推荐的方式是使用两个事件循环组。
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //创建启动服务器的对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup, workerGroup) //group方法将接收两个参数：父事件循环组，子事件循环组
                    .channel(NioServerSocketChannel.class) //bossGroup的通道，只是负责连接
                    .childHandler(new TestChannelnitializer()); //workerGroup的处理器

            ChannelFuture channelFuture = serverBootstrap.bind(8999).sync();  //绑定端口
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
