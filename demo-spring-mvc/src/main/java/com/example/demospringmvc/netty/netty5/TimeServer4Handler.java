package com.example.demospringmvc.netty.netty5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author changyanan1
 */
public class TimeServer4Handler extends ChannelHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf byteBuf = (ByteBuf) msg;
//        byte[] req = new byte[byteBuf.readableBytes()];
//        byteBuf.readBytes(req);
//        String body = new String(req, "UTF-8");
//        System.err.println("The time server receive order:" + body);
//        ByteBuf resp = Unpooled.copiedBuffer("请求已收到！".getBytes());
//        ctx.write(resp);
        String msgStr = msg.toString();
        System.err.println("读入client消息:" + msgStr);
        String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        ByteBuf resp = Unpooled.copiedBuffer(currentTime + System.getProperty("line.separator"), CharsetUtil.UTF_8);
        ctx.writeAndFlush(resp);
        System.out.println("向客户端发送消息");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
