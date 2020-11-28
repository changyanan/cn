package com.example.demospringmvc.netty.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * @author changyanan1
 */
public class MsgpackEncoder extends MessageToByteEncoder {
    /**
     * 编码器
     *
     * @param channelHandlerContext
     * @param o
     * @param byteBuf
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        MessagePack messagePack = new MessagePack();
        byte[] write = messagePack.write(o);
        byteBuf.writeBytes(write);
    }
}
