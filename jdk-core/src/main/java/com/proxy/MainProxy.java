package com.proxy;

import java.lang.reflect.Proxy;

public class MainProxy {

    public static void main(String[] args) {

        Object o = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Move.class}, new LogHandler());
//        Move move = (Move) o;
//        move.move("aaa");
        Class<?> aClass = o.getClass();
        Object o1 = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Move.class}, new TimeHandler());
        Move move = (Move) o1;
        move.move("aaa");
    }

}
