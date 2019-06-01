package com.study.customer.controller;

import com.study.customer.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 该方法表示不通过Eureka注册中心进行调用，直接通过http://host:port进行调用
	 * @param id
	 * @return
	 */
	@GetMapping("/user/{id}")
	public Users getUserById(@PathVariable int id){
		return restTemplate.getForObject("http://localhost:8002/"+id, Users.class);
	}

}
