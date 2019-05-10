package com.study.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableDiscoveryClient 该标识用来声明这个一个Eureka Client
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CustomerApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
