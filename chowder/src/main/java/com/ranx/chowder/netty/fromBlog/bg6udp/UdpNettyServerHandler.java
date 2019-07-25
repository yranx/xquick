package com.ranx.chowder.netty.fromBlog.bg6udp;

import java.util.concurrent.ThreadLocalRandom;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

/**
 * @Description
 * @author ranx
 * @date 2018年11月1日 下午2:35:41
 *
 */
public class UdpNettyServerHandler extends SimpleChannelInboundHandler<DatagramPacket>{
    private static final String[] DICTIONARY = {
            "莫等闲、白了少年头，空悲切！",
            "大江东去，浪淘尽，千古风流人物。",
            "但愿人长久，千里共婵娟。",
            "金风玉露一相逢，便胜却人间无数。",
            "桃之夭夭，灼灼其华。"
    };

    /**
     * ThreadLocalRandom:线程本地变量，每个生成随机数的线程都有一个不同的生成器，是Random的子类，
     *    在多线程并发情况下，ThreadLocalRandom相对于Random可以减少多线程资源竞争，保证了线程的安全性。
     * current()：静态方法，返回与当前线程关联的TaskLocalRandom对象
     */
    public String nextQuote() {
        int quoteId = ThreadLocalRandom.current().nextInt(DICTIONARY.length);
        return DICTIONARY[quoteId];
    }
    /**
     * DatagramPacket 是消息容器，被 DatagramChannel使用，用来和远程设备交流
     *    它实现了AddressedEnvelope接口，包含了发送者和接收者的消息，
     * 	通过content()来获取消息内容
     * 	通过sender()来获取发送者的消息
     *      通过recipient()来获取接收者的消息
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        // 通过content()来获取消息内容
        String req = msg.content().toString(CharsetUtil.UTF_8);
        System.out.println(req);
        if ("查询".equals(req)) {
            ctx.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("查询结果：" + nextQuote(), CharsetUtil.UTF_8), msg.sender()));
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
        cause.printStackTrace();
    }
}