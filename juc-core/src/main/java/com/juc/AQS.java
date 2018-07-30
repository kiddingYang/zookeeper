package com.juc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class AQS {

    public static final int a = 11;
    public int b = 21;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //获取属性
        Field f=Unsafe.class.getDeclaredField("theUnsafe");
        //
        f.setAccessible(true);
        //获取实例
        Unsafe unsafe=(Unsafe) f.get(null);

        long a = unsafe.staticFieldOffset(AQS.class.getDeclaredField("a"));
        long b = unsafe.objectFieldOffset(AQS.class.getDeclaredField("b"));

        System.out.println(a + "\n" +b);

        Object baseA = unsafe.staticFieldBase(AQS.class.getDeclaredField("a"));
        int anInt = unsafe.getInt(baseA,a);

        AQS aqs = new AQS();
        long baseB = unsafe.objectFieldOffset(AQS.class.getDeclaredField("b"));

        int anInt1 = unsafe.getInt(aqs, baseB);
        System.out.println(anInt1);
        int andAddInt = unsafe.getAndAddInt(aqs, baseB, 3);
        System.out.println(andAddInt);
        System.out.println(aqs.b);
        System.out.println(anInt);


    }

}
