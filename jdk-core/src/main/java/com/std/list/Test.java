package com.std.list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

    public static void main(String[] args) {

//        java.util.LinkedList<String> linkedList = new  java.util.LinkedList<>();
//        java.util.ArrayList<String> linkedList = new java.util.ArrayList<>();
        java.util.concurrent.CopyOnWriteArrayList linkedList = new CopyOnWriteArrayList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if(next.equals("2")) {
                linkedList.add("4");
            }
        }


        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }

    }

}
