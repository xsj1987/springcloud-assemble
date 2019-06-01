### Eureka简介
Eureka是Netflix开源的服务发现组件，本身是一个基于REST的服务，包含Server和Client两部分，可以用来实现微服务的注册与发现。

* Eureka Server提供服务发现的能力，各个微服务启动时，会向Eureka Server注册自己的信息(例如IP、端口、服务名称等)，Eureka Server存储这些信息
* 微服务启动后，会定时(默认30s)向Eureka Server发送心跳
* Eureka Server如果在一定的时间(默认90s)没有接收到心跳，则会注销微服务的实例
* 多个Eureka Server实例互相之间通过复制的方式实现数据的同步
* Eureka Client会缓存服务注册表中的信息，这样即使Eureka Server宕掉依然可以保证服务可用

### Eureka Server配置
1. 引入jar包
```java
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>
```
2. 在启动类上添加Eureka注解@EnableEurekaServer，声明这是一个Eureka Server
3. 在配置文件中新增如下内容
```java
eureka:
  client:
    # 是否将自己注册到Eureka Server，默认为true
    registerWithEureka: false
    # 是否从Eureka Server获取注册信息，默认为true
    fetchRegistry: false
    serverUrl:
      # 设置与Eureka交互的地址，查询服务和注册服务都依赖这个地址，多个地址用,分隔
      defaultZone: http://localhost:8761/eureka/
```
### 微服务注册
1. 在微服务中添加jar包
```java
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```
2. 在启动类上添加Eureka注解@EnableDiscoveryClient，声明这是一个Eureka Client
3. 在配置文件中新增如下内容
```java
spring:
  application:
    # 指定注册到Eureka Server上的应用名称
    name: provider-service
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
  instance:
    # 表示将自己的IP注册到Eureka Server，默认为false，如果不配置，则表示将微服务所在操作系统的hostname注册到Eureka Server
    prefer-ip-address: true
```
### Eureka Server的高可用
Eureka Server可以通过运行多个实例并相互注册的方式实现高可用部署，Eureka Server实例会彼此增量的同步信息，从而确保节点数据一致，将defaultZone的地址改为其他Eureka Server地址就可以了