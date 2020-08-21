package com.hcl.ecommerce.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.ecommerce.dto.ResponseMessageDto;
import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.exceptions.UserNotfoundException;
import com.hcl.ecommerce.model.User;
import com.hcl.ecommerce.service.LoginService;


@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginControllerTest {

	@InjectMocks
	LoginController loginController;
	@Mock
	LoginService loginService;

	@Test
	public void testFindByUserNameAndPasswordForPositive() throws UserNotfoundException {
		User userLogin = new User();
		UserLoginDto userDto = new UserLoginDto();
		Mockito.when(loginService.login(userDto)).thenReturn(userLogin);
		ResponseEntity<ResponseMessageDto> user1 = loginController.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());

	}

	@Test
	public void testFindByCustomerIdAndPasswordForNegative() throws UserNotfoundException {
		User userLogin = new User();
		UserLoginDto userDto = new UserLoginDto();
		Mockito.when(loginService.login(userDto)).thenReturn(userLogin);
		ResponseEntity<ResponseMessageDto> user1 = loginController.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals(HttpStatus.OK, user1.getStatusCode());

	}
}
