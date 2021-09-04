ribbon：负载均衡算法

RoundRobinRule 轮询

RandomRule	随机

RetryRule	先走1方法，重试

WeighteResponseTimeRule	1的扩展，响应速度越快的实例更容易被选择

BestAvaliableRule 过滤掉多次访问故障而处于断路器跳闸在的服务然后选择。

AvailabiltyFilteringRule	过滤故障，选择并发较小的

ZoneAvoidanceRule	符合判断server所在区域的性能和可用性

