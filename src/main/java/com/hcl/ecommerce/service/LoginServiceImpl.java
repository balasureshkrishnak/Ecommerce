package com.hcl.ecommerce.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.exceptions.UserNotfoundException;
import com.hcl.ecommerce.model.User;
import com.hcl.ecommerce.repository.UserRepo;






@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepo loginRepository;

	@Override
	public User login(UserLoginDto userLoginDto) throws UserNotfoundException   {
	


		User login = loginRepository.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
		if (login==null) {
			throw new UserNotfoundException("User doesnot exists");
		}
		
		
		return login;
		
	}
}
