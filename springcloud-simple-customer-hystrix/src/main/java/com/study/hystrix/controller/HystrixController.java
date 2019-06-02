package com.study.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.hystrix.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 该方法通过Eureka发现服务，解耦，不与IP直接绑定
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    @GetMapping("/user/{id}")
    public Users getUserByIdAndEureka(@PathVariable int id){
        return restTemplate.getForObject("http://provider-server/"+id, Users.class);
    }

    public Users findByIdFallback(int id){
        Users users = new Users();
        users.setId(-1);
        users.setUserName("默认用户");
        return users;
    }
}
