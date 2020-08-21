package com.hcl.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.dto.UserRegistrationDto;
import com.hcl.ecommerce.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

	private UserLoginDto userLoginDto = new UserLoginDto();

	@PostMapping(value = "/user")
	public ResponseEntity<Object> addUser(@RequestBody UserRegistrationDto userRegistrationDto) throws Exception {
		userLoginDto = userService.createUser(userRegistrationDto);
		return new ResponseEntity<>(userLoginDto, HttpStatus.OK);

	}

	

}
