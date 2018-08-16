package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("start....");
//        Object invoke = method.invoke(args);
        System.out.println("move to ...." + args[0]);
        System.out.println("end.....");
        return null;
    }
}
