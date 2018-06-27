package com.callable;

import java.util.concurrent.*;

public class CallableTest {

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future submit = executorService.submit(new Callable() {
            public Object call() throws Exception {
                return 1+1;
            }
        });
        Object o = submit.get();
        System.out.println(o);
    }

}
