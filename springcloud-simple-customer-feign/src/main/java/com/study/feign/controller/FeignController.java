package com.study.feign.controller;

import com.study.feign.entity.Users;
import com.study.feign.services.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FeignController {

    @Autowired
    private UserFeignClient userFeignClient;


    @GetMapping("/user/{id}")
    public Users getUserByIdAndEureka(@PathVariable int id){
        return userFeignClient.findById(id);
    }

    @GetMapping("/user/getInfo")
    public Users getUserInfo(){
        Map<String, Object> map = new HashMap<>();
        map.put("id",5);
        map.put("userName", "张大炮");
        return userFeignClient.getInfo(map);
    }

    @GetMapping("/user/postInfo")
    public Users postUserInfo(){
        Users users = new Users();
        users.setCreateDate(new Date());
        users.setUserName("root");
        users.setPassword("root");
        return userFeignClient.postInfo(users);
    }
}
