package com.misaka.zk;

import java.io.IOException;
import java.util.List;
import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @author 517
 * @date 2021-09-02 - 18:39
 */
public class zkClient {

    private String connectString = "host:port,host2:port,host3:port";
    private int sessionTimeout = 2000;
    ZooKeeper zookeeper;
    @Before
    public void init() throws IOException {
        zookeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @lombok.SneakyThrows
            @Override
            public void process(WatchedEvent watchedEvent) {
                List<String> children = zookeeper.getChildren("/path", true);
                for (String node :
                        children) {
                    System.out.println(node);
                }
            }
        });
    }

    @Test
    public void create() throws InterruptedException, KeeperException {
        zookeeper.create("/path","whatsData".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void getChild() throws InterruptedException, KeeperException {
        List<String> children = zookeeper.getChildren("/path", true);
        zookeeper.exists("/path",false);//是否存在
    }

}
