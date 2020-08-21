package com.hcl.ecommerce.service;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.dto.ResponseDto;
import com.hcl.ecommerce.entity.OrderHistory;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.OrderHistoryRepository;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.repository.UserRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceImplTest {
	
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Mock
	UserRepository userRepository;

	@Mock
	ProductRepository productRepository;
	
	@Mock
	OrderHistoryRepository orderHistoryRepository;
	
	@Before
	public static void setupMethod() {
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("pc");
		product.setProductDesc("personal computer");
		product.setProductPrice(200.00);
		
		User user = new User();
		user.setUserId(1);
		user.setUserName("bala");
		user.setAddress("bangalore");
		user.setEmail("bala.k@gmail.com");
		user.setPassword("bala");
		user.setPhone("9705441499");
		
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.setOrderHistoryId(1);
		orderHistory.setProduct(product);
		orderHistory.setTotalCost(200.00);
		orderHistory.setUser(user);
		
		ProductDto productDto = new ProductDto();
		productDto.setProductId(1);
		productDto.setProductName("pc");
		productDto.setProductDesc("personal computer");
		productDto.setProductPrice(200.00);
	}
	
	
	@Test
	public void testForBuyProductForPositive() {
		ResponseDto responseDto = new ResponseDto();
		ProductDto productDto = new ProductDto();
		Product product = new Product();
		User user = new User();
		OrderHistory orderHistory = new OrderHistory();
		Mockito.when(productRepository.findByProductId(Mockito.anyInt())).thenReturn(Optional.of(product));
		
		Mockito.when(userRepository.findByUserId(Mockito.anyInt())).thenReturn(Optional.of(user));
		
		Mockito.when(orderHistoryRepository.save(orderHistory)).thenReturn(orderHistory);
		responseDto = productServiceImpl.buyProduct(1, productDto);
		
		Assert.assertEquals("Order placed successfully", responseDto.getStatusMessage());
	}

}
