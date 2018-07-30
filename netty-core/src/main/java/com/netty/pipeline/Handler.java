package com.netty.pipeline;

public interface Handler {

    void channelRead(HandlerContext ctx, Object msg);

}
