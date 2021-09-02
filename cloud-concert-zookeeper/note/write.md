超过半数写成功就算成功
    cli连接leader，leader告诉follower开始写，超过半数leader返回成功ack
    连接follower，转发给leader，等ack应答