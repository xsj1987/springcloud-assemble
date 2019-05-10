package com.study.provider.controller;

import com.study.provider.entity.Users;
import com.study.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public Users getUserById(@PathVariable int id){
		return userService.findById(id);
	}
}
