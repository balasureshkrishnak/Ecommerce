package com.hcl.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.dto.UserRegistrationDto;
import com.hcl.ecommerce.model.User;
import com.hcl.ecommerce.service.UserService;



@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	@Test
	public void testCreateUserForPositive() throws Exception {
		User user = new User();
		UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
		UserLoginDto userDto = new UserLoginDto();
		Mockito.when(userService.createUser(userRegistrationDto)).thenReturn(userDto);
		ResponseEntity<Object> user1 = userController.addUser(userRegistrationDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());
	}

	@Test
	public void testCreateUserForNegative() throws Exception {
		User user = new User();
		UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
		UserLoginDto userDto = new UserLoginDto();
		Mockito.when(userService.createUser(userRegistrationDto)).thenReturn(userDto);
		ResponseEntity<Object> user1 = userController.addUser(userRegistrationDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());
	}

	

}
