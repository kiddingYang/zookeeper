package com.std.mq;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Administrator on 2018/7/28.
 */
public class JdkTmp {

//    private static ArrayList<Integer> arrayList = new ArrayList<>();

//    private static Vector<Integer> arrayList = new Vector<>();

    private static CopyOnWriteArrayList<Integer> arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {

        arrayList.add(0,1);

        new Thread(){
            @Override
            public void run() {
                arrayList.add(1,2);
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                arrayList.add(2,3);
            }
        }.start();

       System.out.println(arrayList.size());
       System.out.println(arrayList);

    }



}
