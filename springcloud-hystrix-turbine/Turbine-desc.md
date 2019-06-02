### Turbine简介
Turbine是一个聚合Hystrix监控数据的工具，它可将所有相关的/hystrix.stream端点的数据聚合到一个组合的/turbine.stream中，这样可以在dashboard中不用切换多个地址
### Turbine配置
1. 引入依赖
```java
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-turbine</artifactId>
</dependency>
```
2. 在启动类上添加注解@EnableTurbine
3. 修改配置文件，将项目注册到Eureka中
```java
eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/
  instance:
    prefer-ip-address: true

# 从Eureka中查找名为customer-hystrix-server的服务并聚合监控数据
turbine:
  appConfig: customer-hystrix-server
  clusterNameExpression: "'default'"
```
4. Turbine与RabbitMQ集成
Turbine可以通过消息中间件进行监控数据的收集 