### springcloud-assemble
#### springcloud-admin配置
简介：用来监控微服务或应用数据，包括被监控spring-boot项目的基本信息，详细的Health信息、内存信息、JVM信息、垃圾回收信息、各种配置信息（比如数据源、缓存列表和命中率）等，还可以直接修改logger的level。

应用通过HTTP或者使用Eureka注册到admin server中进行展示，Spring Boot Admin UI部分使用AngularJs将数据展示在前端。独立服务

[详情](/springcloud-admin/Admin-desc.md)
#### springcloud-eureka配置
简介：服务发现组件，提供服务注册、发现和检查。独立服务

[详情](/springcloud-eureka-server/Eureka-desc.md)
#### springcloud-ribbon配置
简介：基于某种负载均衡算法(轮询、随机、自定义)帮助服务消费者去请求服务。集成在消费服务中

[详情](/springcloud-simple-customer-ribbon/Ribbon-desc.md)
#### springcloud-hystrix配置
简介：为服务提供容错机制，防止雪崩效应。集成在消费服务中

[详情](/springcloud-simple-customer-hystrix/Hystrix-desc.md)
#### springcloud-dashboard配置
简介：可视化Hystrix监控数据，只能配置一个Hystrix项目地址

[详情](/springcloud-simple-customer-hystrix-dashboard/Dashboard-desc.md)
#### springcloud-turbine配置
简介：聚合多个Hystrix项目监控数据，方便可视化插件Dashboard查询

[详情](/springcloud-hystrix-turbine/Turbine-desc.md)
#### springcloud-Feign配置
简介：声明式、模板化的HTTP客户端

[详情](/springcloud-simple-customer-feign/Feign-desc.md)