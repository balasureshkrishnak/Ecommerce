package com.hcl.ecommerce.service;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.dto.ResponseDto;

public interface ProductService {
	
	public ResponseDto buyProduct(Integer userId, ProductDto productDto);

}
