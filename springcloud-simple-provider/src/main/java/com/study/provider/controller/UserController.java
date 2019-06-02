package com.study.provider.controller;

import com.study.provider.entity.Users;
import com.study.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public Users getUserById(@PathVariable int id){
		return userService.findById(id);
	}

	@GetMapping("/get")
	public Users getInfo(@RequestParam Map<String, Object> map){
		System.out.println(map);
		return new Users();
	}

	@PostMapping("/post")
	public Users postInfo(@RequestBody Users users){
		System.out.println(users);
		return new Users();
	}
}
