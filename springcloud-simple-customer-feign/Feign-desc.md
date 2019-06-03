### Feign简介
Feign是Netflix开发的声明式、模板化的HTTP客户端。SpringCloud对Feign进行了增强，是Feign支持了SpringMVC注解，并整合了Ribbon和Eureka。
### Feign配置
1. 引入依赖
```java
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-feign</artifactId>
</dependency>
```
2. 在启动类上添加@EnableFeignClients注解
3. 创建Feign接口，并添加@FeignClient注解
### Feign自定义配置
在SpringCloud中，Feign默认的配置类为FeignClientsConfiguration，可以自定义配置类，即@Configuration注解的类，不过该类不要在@ComponentScan中

在Feign接口中，在注解@FeignClient中添加configuration属性，引入自定义配置
### Feign对压缩的支持
启用请求压缩\
feign.compression.request.enabled=true\
启用响应压缩\
feign.compression.response.enabled=true\
支持的媒体类型列表\
feign.compression.request.mime-types=text/xml,application/xml,application/json\
请求的最小阈值\
feign.compression.request.min-request-size=2048
### Feign日志
Feign会对每个客户端创建一个Logger，可以分别指定每个Logger的记录策略，不过Feign的日志打印只对DEBUG级别做出响应

* NONE：不记录任何日志
* BASIC：仅记录请求方法、URL、响应状态代码及执行时间
* HEADERS：在BASIC的基础上，记录请求和响应的header
* FULL：记录请求和响应的header、body和元数据
### 构造多参请求
在Feign中，请求只使用POST发送

可以使用@RequestParam传递参数，也可以使用@RequestBody传递对象
