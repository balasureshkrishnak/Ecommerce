package com.hcl.ecommerce.service;

import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.exceptions.UserNotfoundException;
import com.hcl.ecommerce.model.User;

public interface LoginService {

	User login(UserLoginDto userLoginDto) throws UserNotfoundException ;

}
