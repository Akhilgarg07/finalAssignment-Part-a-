package com.nagarro.hrLogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.hrLogin.entity.User;
import com.nagarro.hrLogin.repository.UserRepository;

@Service
public class UserRegisterService {

	@Autowired
	private UserRepository userRepo;

	public void userRepoSave(User user) {
		userRepo.save(user);
	}

}
