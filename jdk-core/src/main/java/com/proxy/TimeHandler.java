package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TimeHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(System.currentTimeMillis());
//        Object invoke = method.invoke(args);
        TimeUnit.SECONDS.sleep(5);
        System.out.println(System.currentTimeMillis());
        return null;
    }
}
