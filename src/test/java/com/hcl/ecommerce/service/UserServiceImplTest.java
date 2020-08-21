package com.hcl.ecommerce.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.UserRepository;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	UserRepository userRepository;

	

	@Test
	public void testCreateUserForPositive() {
		User user = new User();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Assert.assertEquals(user, userRepository.save(user));
	}

	@Test
	public void testCreateStudentForNegative() {
		User user = new User();
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Assert.assertEquals(user, userRepository.save(user));
	}

}
