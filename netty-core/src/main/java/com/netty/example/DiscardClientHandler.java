package com.netty.example;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class DiscardClientHandler extends SimpleChannelInboundHandler<MyBean> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyBean msg) throws Exception {
        System.out.println("receive msg:"+msg);
        MyBean response = new MyBean();
        response.setId(msg.getId());
        response.setMsg("response msg");
        ctx.writeAndFlush(response);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        MyBean request = new MyBean();
//        request.setId(20);
//        request.setMsg("response msg");
//        ctx.writeAndFlush(request);
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", //2
                CharsetUtil.UTF_8));
    }
}
