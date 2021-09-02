监听过程：
    1.main()线程，在其中创建zk客户端
    2.会生成两个线程，一个负责通信 connect，一个负责监听 listener
    3.connect告诉服务端监听什么
    4.服务端获取后添加事件，有变化返回listener，内部调用process()

get -w /path 开始监听节点值的变化 ，注册一次监听一次
ls -w /path 监听节点数的变化