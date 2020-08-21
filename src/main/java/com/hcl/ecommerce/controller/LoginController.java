package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.ResponseMessageDto;
import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.exceptions.UserNotfoundException;
import com.hcl.ecommerce.service.LoginService;


@RestController
public class LoginController {
	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<ResponseMessageDto> login(@RequestBody UserLoginDto userLoginDto) throws UserNotfoundException  {
		ResponseMessageDto responseMessageDto = new ResponseMessageDto();
		loginService.login(userLoginDto);
		responseMessageDto.setMessage("user Logged in Sucessfully");
		return new ResponseEntity<>(responseMessageDto, HttpStatus.OK);

	}

}
