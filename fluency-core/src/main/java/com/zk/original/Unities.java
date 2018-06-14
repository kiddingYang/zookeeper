package com.zk.original;

import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class Unities {


    private static final String zkServer = "111.231.62.191";
    private static final int zkPort = 2181;
    private ZooKeeper zooKeeper;

    @Before
    public void initZkConfig() {

        try {
            zooKeeper = new ZooKeeper(zkServer,zkPort,null);
            System.out.println(zooKeeper.getState().isAlive());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("cant connect to server : " + zkServer);
        }
    }

    @Test
    public void createNode() {



    }


}
