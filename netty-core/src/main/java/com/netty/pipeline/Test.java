package com.netty.pipeline;

public class Test {

    public static void main(String[] args) {
        Pipeline pipeline = new Pipeline();
        pipeline.addFirst(new Handler() {
            @Override
            public void channelRead(HandlerContext ctx, Object msg) {
                System.out.println("msg 1 : "+msg );
                ctx.write(msg+"1");
            }
        }).addFirst(new Handler() {
            @Override
            public void channelRead(HandlerContext ctx, Object msg) {
                System.out.println("msg 2 : "+msg );
                ctx.write(msg+"2");
            }
        });

        pipeline.Request("request");


    }

}
