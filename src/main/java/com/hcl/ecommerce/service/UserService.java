package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.dto.UserRegistrationDto;



public interface UserService {

	

	UserLoginDto createUser(UserRegistrationDto userRegistrationDto);

}
