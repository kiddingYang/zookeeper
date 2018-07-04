package com.netty.example;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class JdkEncoder extends MessageToByteEncoder<MyBean> {

    protected void encode(ChannelHandlerContext ctx, MyBean msg, ByteBuf byteBuf) throws Exception {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(msg);
        oos.flush();
        byteBuf.writeBytes(bos.toByteArray());
        bos.close();
        oos.close();

    }

}
