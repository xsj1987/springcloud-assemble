package com.study.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 添加Feign日志配置
 * Feign日志有四种选项
 * NONE：不记录任何日志
 * BASIC：仅记录请求方法、URL、响应状态代码及执行时间
 * HEADERS：在BASIC的基础上，记录请求和响应的header
 * FULL：记录请求和响应的header、body和元数据
 */
@Configuration
public class FeignLogConfiguration {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
