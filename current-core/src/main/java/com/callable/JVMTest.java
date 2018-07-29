package com.callable;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/7/20.
 */
public class JVMTest {

    public static void main(String[] args) throws InterruptedException {

        ArrayList list = new ArrayList();
        for (int i = 0;i<1000;i++) {
            Object[] objects = new Object[100];
            objects[i%100] = i;
            list.add(objects);
        }
        Thread.sleep(100000000);
    }


}
