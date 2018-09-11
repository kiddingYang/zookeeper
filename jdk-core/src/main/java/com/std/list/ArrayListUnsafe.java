package com.std.list;

/**
 * Created by Administrator on 2018/7/31.
 */
public class ArrayListUnsafe {

    public static void main(String[] args) {

//        java.util.ArrayList<Integer> arrayList = new java.util.ArrayList<>(2);
//        java.util.Vector<Integer> arrayList = new java.util.Vector<>(2);
        java.util.concurrent.CopyOnWriteArrayList<Integer> arrayList = new java.util.concurrent.CopyOnWriteArrayList();
        arrayList.add(1);
        arrayList.add(2);

        new Thread(){
            @Override
            public void run() {
                arrayList.add(4);
            }
        }.start();


        arrayList.add(3);




    }

}
