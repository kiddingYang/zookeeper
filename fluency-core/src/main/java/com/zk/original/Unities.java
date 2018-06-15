package com.zk.original;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Unities {


    private static final String zkServer = "111.231.62.191";
    private static final int zkPort = 2181;
    private ZooKeeper zooKeeper;
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    @Before
    public void initZkConfig() {

        try {
            zooKeeper = new ZooKeeper(zkServer,zkPort,null);
            System.out.println(zooKeeper.getState().isAlive());
            TimeUnit.SECONDS.sleep(2);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("cant connect to server : " + zkServer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步创建Znode
     */
    @Test
    public void syncCreateNode() {
        try {
            String nodePath = zooKeeper.create("/node1", "node1Data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("create node path : " + nodePath);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步创建Znode
     */
    @Test
    public void asyncCreateNode() throws InterruptedException {
        zooKeeper.create("/asyncNode1", "asyncNode2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, new AsyncCallback.StringCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx, String name) {
                System.out.println("rc : " + rc + " path : " + path + " ctx : " + ctx + " name: " + name);
                countDownLatch.countDown();

            }
        }, Arrays.asList(1,2,4,3));
        countDownLatch.await();
    }


    /**
     * 同步删除node
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void syncDeleteNode() throws KeeperException, InterruptedException {
        zooKeeper.delete("/node1",-1);
    }


    /**
     * 异步删除node
     * @throws InterruptedException
     */
    @Test
    public void asyncDeleteNode() throws InterruptedException {
        zooKeeper.delete("/asyncNode1", -1, new AsyncCallback.VoidCallback() {
            @Override
            public void processResult(int rc, String path, Object ctx) {
                System.out.println("rc : " + rc + " path : " + path + " ctx : " + ctx);
                countDownLatch.countDown();
            }
        },null);
        countDownLatch.await();
    }


    /**
     * 获取node data数据
     */
    @Test
    public void syncGetNodeDate() throws KeeperException, InterruptedException {

        Stat stat = new Stat();
        byte[] data = zooKeeper.getData("/node1", false, stat);
        System.out.println(new String(data) + " stat :" + stat);

    }

}
