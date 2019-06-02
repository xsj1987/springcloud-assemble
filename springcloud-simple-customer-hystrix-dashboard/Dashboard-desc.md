### Dashboard简介
独立项目，以图表的形式展示Hystrix的监控数据
### Dashboard配置
1. 引入依赖
```java
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
</dependency>
```
2. 在启动类上添加@EnableHystrixDashboard注解
3. 访问地址http://ip:port/hystrix