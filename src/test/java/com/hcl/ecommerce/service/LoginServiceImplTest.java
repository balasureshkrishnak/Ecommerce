package com.hcl.ecommerce.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.exceptions.UserNotfoundException;
import com.hcl.ecommerce.model.User;
import com.hcl.ecommerce.repository.UserRepo;



@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginServiceImplTest {

	@InjectMocks
	LoginServiceImpl loginServiceImpl;
	@Mock
	UserRepo LoginRepository;

	@Test(expected = UserNotfoundException.class)
	public void testFindByEmailAndPasswordForException() throws UserNotfoundException {
		User user = new User();
		UserLoginDto userDto = new UserLoginDto();
		userDto.setPassword("chandhu");
		Mockito.when(LoginRepository.findByEmailAndPassword((String) "chan", "chandhini")).thenReturn(user);
		User user1 = loginServiceImpl.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals("chandhu", user1.getPassword());

	}

	@Test(expected = UserNotfoundException.class)
	public void testFindByEmailAndPasswordForException1() throws UserNotfoundException {
		User user = new User();

		UserLoginDto userDto = new UserLoginDto();
		userDto.setPassword("chandhu");

		Mockito.when(LoginRepository.findByEmailAndPassword((String) "chan", "chandhini")).thenReturn(user);
		User user1 = loginServiceImpl.login(userDto);
		Assert.assertNotNull(user1);
		Assert.assertEquals("chandhu", user1.getPassword());

	}

}
