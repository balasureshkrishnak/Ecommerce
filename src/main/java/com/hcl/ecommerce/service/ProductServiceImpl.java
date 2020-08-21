package com.hcl.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.dto.ResponseDto;
import com.hcl.ecommerce.entity.OrderHistory;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.OrderHistoryRepository;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.repository.UserRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderHistoryRepository orderHistoryRepository;

	public ResponseDto buyProduct(int userId, ProductDto productDto) {

		double totalCost = 0.00;
		ResponseDto responseDto = new ResponseDto();
		Optional<Product> products = productRepository.findByProductId(productDto.getProductId());
		if (products.isPresent()) {
			Product buyProduct = products.get();
			totalCost = totalCost + (buyProduct.getProductPrice());

		}

		Optional<User> users = userRepository.findByUserId(userId);
		if (users.isPresent()) {

			User user = users.get();
			Product product = new Product();
			OrderHistory orderHistory = new OrderHistory();
			BeanUtils.copyProperties(productDto, product);
			orderHistory.setProduct(product);
			orderHistory.setTotalCost(totalCost);
			orderHistory.setUser(user);
			orderHistoryRepository.save(orderHistory);

			responseDto.setStatusMessage("Order placed successfully");
			responseDto.setStatusCode(HttpStatus.CREATED.value());
			return responseDto;
		} else {
			responseDto.setStatusMessage("user not found");
			responseDto.setStatusCode(HttpStatus.CREATED.value());
			return responseDto;
		}
	}

}
