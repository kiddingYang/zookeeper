package com.netty.pipeline;

public class Pipeline {

    private HandlerContext head;
    private HandlerContext tail;

    public Pipeline addFirst(Handler handler) {
        HandlerContext handlerContext = new HandlerContext(handler);
        HandlerContext tmp = head;
        head = handlerContext;
        head.addLast(tmp);
        return this;
    }

    public Pipeline() {
        head = tail = new HeadContext(new HeadHandler());
    }

    public void Request(Object msg) {//封装了外部调用接口
        head.doWork(msg);
    }

    final class HeadContext extends HandlerContext {//这是一个内部类，为默认handler的context

        public HeadContext(Handler handler) {
            super(handler);
        }
    }

    final class HeadHandler implements Handler {//这是一个内部类，是pipeline的默认处理handler。

        @Override
        public void channelRead(HandlerContext ctx, Object msg) {
            String result = (String) msg + "end";
            System.out.println(result);
        }

    }
}
