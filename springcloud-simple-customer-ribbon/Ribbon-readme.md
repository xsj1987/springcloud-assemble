### Ribbon简介
Ribbon是Netflix发布的负载均衡器，有助于控制HTTP和TCP客户端的行为。为Ribbon配置服务提供者地址列表后，Ribbon就可以基于某种负载均衡算法自动的帮助服务消费者去请求。Ribbon提供了多种默认均衡算法，比如轮询、随机等，也可以自定义负载均衡算法
### Ribbon配置
1. 引入Ribbon的Spring-cloud-starter-ribbon.jar
```java
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-ribbon</artifactId>
</dependency>
```
2. 添加配置
```java
# 提供服务的服务地址列表，provider-server表示服务提供者名称，多个地址用,分隔
provider-server:
  ribbon:
    listOfServers: localhost:8002
```
### Ribbon+Eureka配置
1. 引入jar包，Eureka包已经包含了Ribbon的Spring-cloud-starter-ribbon.jar。所以无须再次引入
2. 在实例化RestTemplate上添加@LoadBalanced注解
3. 在调用方法时，可以通过服务名进行调用，不需要与IP直接绑定

