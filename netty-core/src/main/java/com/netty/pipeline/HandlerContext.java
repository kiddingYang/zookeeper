package com.netty.pipeline;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlerContext {

    private ExecutorService executorService = Executors.newFixedThreadPool(2);
    private Handler handler;
    private HandlerContext handlerContext;

    public HandlerContext(Handler handler) {
        this.handler = handler;
    }

    public void addLast(HandlerContext handlerContext){
        this.handlerContext = handlerContext;
    }

    public void doWork(final Object msg){//执行任务的时候向线程池提交一个runnable的任务，任务中调用handler
        if(handlerContext==null){
            return;
        }else {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                   handler.channelRead(handlerContext,msg);
                }
            });
        }
    }
    public void write(Object msg){//这里的write操作是给handler调用的，实际上是一个回调方法，当handler处理完数据之后，调用一下nextcontext.write，此时就把任务传递给下一个handler了。
        doWork(msg);
    }


}
