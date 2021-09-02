奇数安装

请求先进先出。

事务原子性;实时性

树形结构，每个节点znode大概1mb

提供的服务：
    同一命名服务：域名下存储多个ip地址
    统一配置管理：

# 心跳间隔
tickTime=2000
# The number of ticks that the initial
# synchronization phase can take
#初始化时的心跳上限次数
initLimit=10
# The number of ticks that can pass between
# sending a request and getting an acknowledgement
#连接后的心跳上限次数
syncLimit=5
# the directory where the snapshot is stored.
# do not use /tmp for storage, /tmp here is just
# example sakes.
dataDir=/data/zk
# the port at which the clients will connect
clientPort=2181


server.1=host:LF-port:ReLeaderPort
#server.1=localhost:2888：3888