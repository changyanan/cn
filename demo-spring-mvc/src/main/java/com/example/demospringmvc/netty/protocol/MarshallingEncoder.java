package com.example.demospringmvc.netty.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import org.jboss.marshalling.Marshaller;

import java.io.IOException;

/**
 * @author changyanan1
 */
@ChannelHandler.Sharable
public class MarshallingEncoder {
    private static final byte[] LENGTH_PLACEHOLDER = new byte[4];
    Marshaller marshaller;

    public MarshallingEncoder() throws IOException {
        this.marshaller = MarshallingCodecFactory.buildMarshaller();
    }

    /**
     * 使用marshall对Object进行编码，并且写入bytebuf...
     *
     * @param msg
     * @param buf
     * @throws IOException
     */
    protected void encode(Object msg, ByteBuf buf) throws IOException {
        //获取写入位置
        int index = buf.writerIndex();
        //先写入4个byte.用于记录Object编码后的长度
        buf.writeBytes(LENGTH_PLACEHOLDER);
        //使用代理对象，防止marshaller写完关闭byte buff
        ChannelBufferByteOutput output = new ChannelBufferByteOutput(buf);
        try {
            marshaller.start(output);
            marshaller.writeObject(msg);
            marshaller.finish();
            buf.setInt(index, buf.writerIndex() - index - 4);
        } finally {
            marshaller.close();
        }
    }
}
