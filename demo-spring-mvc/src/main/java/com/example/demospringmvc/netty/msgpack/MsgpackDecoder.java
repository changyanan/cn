package com.example.demospringmvc.netty.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * @author changyanan1
 */
public class MsgpackDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        final byte[] arrays;
        int length = byteBuf.readableBytes();
        arrays = new byte[length];
        byteBuf.getBytes(byteBuf.readerIndex(), arrays, 0, length);
        MessagePack messagePack = new MessagePack();
        list.add(messagePack.read(arrays));
    }
}
