package com.study.provider.service.impl;

import com.study.provider.entity.Users;
import com.study.provider.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public Users findById(int id) {
		return new Users(1, "admin", "admin", new Date());
	}
}
