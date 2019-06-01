package com.study.ribbon.constroller;

import com.study.ribbon.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 该方法通过Eureka发现服务，解耦，不与IP直接绑定
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public Users getUserByIdAndEureka(@PathVariable int id){
        return restTemplate.getForObject("http://provider-server/"+id, Users.class);
    }
}
