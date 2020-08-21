package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.dto.ResponseDto;
import com.hcl.ecommerce.service.ProductServiceImpl;


@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@PostMapping("/{userId}")
	public ResponseEntity<ResponseDto> buyProducts(@PathVariable int userId, @RequestBody ProductDto productDto){
		ResponseDto responseDto = productServiceImpl.placeOrder(userId, productDto);
		
		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

}
