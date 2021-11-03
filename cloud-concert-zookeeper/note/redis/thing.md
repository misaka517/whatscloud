redis单条命令具有原子性，事务不保证原子性
redis事务没有隔离级别的概念
一次性，顺序性，排他性

事务步骤：
    开启事务，命令入队，执行事务
    multi，......，exec
    discard取消事务


incr key 自增1
INCRBY key value \key的value的值增加value
DECRBY key value 。。减少。。