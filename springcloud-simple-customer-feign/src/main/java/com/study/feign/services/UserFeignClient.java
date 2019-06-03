package com.study.feign.services;

import com.study.feign.config.FeignLogConfiguration;
import com.study.feign.entity.Users;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * name表示服务的名称，用于创建Ribbon的负载均衡器，也可以通过URL属性直接指定具体的服务提供者
 */
@FeignClient(name="provider-server", configuration = FeignLogConfiguration.class)
public interface UserFeignClient {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Users findById(@PathVariable("id") Integer id);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Users getInfo(@RequestParam Map<String, Object> map);

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Users postInfo(@RequestBody Users users);
}
