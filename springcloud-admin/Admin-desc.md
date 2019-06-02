### Spring Boot Admin
Spring Boot Admin 是一个管理和监控Spring Boot 应用程序的开源软件。
每个应用都认为是一个客户端，通过HTTP或者使用Eureka注册到admin server中进行展示。

Spring Boot Admin UI部分使用AngularJs将数据展示在前端。

Spring Boot Admin 是一个针对spring-boot的actuator接口进行UI美化封装的监控工具。
该工具可以在列表中浏览所有被监控spring-boot项目的基本信息，详细的Health信息、内存信息、JVM信息、垃圾回收信息、各种配置信息（比如数据源、缓存列表和命中率）等，还可以直接修改logger的level。
### 配置项目监控
1. 创建Springboot项目，引入监控
```java
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-server</artifactId>
    <version>1.5.6</version>
</dependency>
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-server-ui</artifactId>
    <version>1.5.6</version>
</dependency>
```
2. 配置访问端口
```java
server:
  port: 8005
```
3. 在需要监控的项目中引入jar包
```java
<!-- 引入监控客户端 -->
<dependency>
    <groupId>de.codecentric</groupId>
    <artifactId>spring-boot-admin-starter-client</artifactId>
    <version>1.5.6</version>
</dependency>
```
4. 在需要监控的项目中配置监控地址
```java
spring:
  boot:
    admin:
      # 配置Admin Server的地址
      url: http://localhost:8005
```
5. 访问监控http://localhost:8005
6. 如果应用客户端注册在Eureka中，那么应用客户端不需要再进行配置，只需引入client包，Admin Server会自动在Eureka中获取需要监控的服务。