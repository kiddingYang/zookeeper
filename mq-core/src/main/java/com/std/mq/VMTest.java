package com.std.mq;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/29.
 */
public class VMTest {

    public static void main(String[] args) throws InterruptedException {

        List list = new ArrayList();
        List list2 = new ArrayList();
//        for (int i=0 ;i<3;i++) {
//            list.add(new1M());
//            list2.add(new1M());
//        }
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
//                    list.add(new1M());
//                    list2.add(new1M());
                    Connection connection = new Connection();
                    connection.setBytes(new1M());
                    connection.setConnectionName("con1");
                    list.add(connection);
                }
            }
        }.start();
        Thread.sleep(10000);
    }

    private static byte[] new1M() {

        byte[] M1 = new byte[1024 * 1024];
        M1[1] = 123;
        System.out.println("M1.....");
        return M1;
    }

}
