package com.misaka.zk;

import java.io.IOException;
import java.util.List;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 517
 * @date 2021-09-02 - 18:39
 */
public class zkClient {

    private String connectString = "node10:2181,node11:2181,node12:2181";
    private int sessionTimeout = 2000;
    ZooKeeper zookeeper;
    @Before
    public void init() throws IOException {
        zookeeper = new ZooKeeper(connectString, sessionTimeout, watchedEvent -> {
            List<String> children = null;
            try {
                children = zookeeper.getChildren("/servers", true);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (String node :
                    children) {
                System.out.println(node);
            }
        });
    }

    @Test
    public void create() throws InterruptedException, KeeperException {
        zookeeper.create("/servers","allService".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void getChild() throws InterruptedException, KeeperException {
        List<String> children = zookeeper.getChildren("/servers", true);
        zookeeper.exists("/servers0000000000",false);//是否存在
        System.out.println(children);
    }

    @Test
    public void getData() throws InterruptedException, KeeperException {
        byte[] data = zookeeper.getData("/servers", false, null);
        System.out.println(new String(data));
    }

}
