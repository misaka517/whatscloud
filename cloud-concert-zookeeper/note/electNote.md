选举：
1）选举开始
2）每个节点首先投票自己，1节点投票自身，不满足半数以上，保持looking
3）2节点再次发起选举，投票自身。1判断myid比2节点的小。将选票投给2节点
4）3发起选举，获得123选票成为leader
5）4发起选举，投票自身，不足3的选票。把选票给3节点（产生leader后不再更换，除非leader下线）

客户端事务：
    SID：服务器id，同myid
    ZXID：事务id
    Epoch：leader任期编号，选举完成一次就会增加

两种情况下开始选举：
    1. 初始化
    2. 无法和leader保持连接
        2.1两种情况：存在leader，本身连接不上，本身发起选举；确实不存在leader
        2.2 1情况下会被告知存在leader。尝试连接。 2情况
        2.3 2情况选举规则：（关注Epoch，ZXID，SID）
                1）Epoch大直接胜出
                2）事务ID大胜出
                3）SID大胜出

集群客户端启动：
    ./zkCli.sh -server host:2181

节点类型：持久，短暂；有序，无序
    持久：客户端和服务端断开连接后创建的节点不删除
    短暂：断开后自己删除
    有序：zk给该节点进行顺序编号，父节点维护，单调递增

    create -s /path 创建永久带序号节点
    create -e /path 短暂
    set /path "value" 修改