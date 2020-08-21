package com.hcl.ecommerce.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.dto.UserRegistrationDto;
import com.hcl.ecommerce.model.User;
import com.hcl.ecommerce.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	private Random random = new SecureRandom();

	@Override
	public UserLoginDto createUser(UserRegistrationDto userRegistrationDto) {
		Random random = new Random();
		User user = new User();
		UserLoginDto userLoginDto = new UserLoginDto();
		BeanUtils.copyProperties(userRegistrationDto, user);

		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 10;

		String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

		user.setPassword(generatedString);

		user = userRepository.save(user);

		BeanUtils.copyProperties(user, userLoginDto);

		return userLoginDto;
	}

	
	}


