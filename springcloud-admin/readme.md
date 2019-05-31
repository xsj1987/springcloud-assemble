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