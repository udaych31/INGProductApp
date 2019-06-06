package com.hcl.ing.product.app.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ing.product.app.dto.ProductDetailsByProduct;
import com.hcl.ing.product.app.dto.ProductGroupListResponse;
import com.hcl.ing.product.app.dto.ProductListResponse;
import com.hcl.ing.product.app.service.ProductServiceImpl;
import com.hcl.ing.product.app.util.ApiResponse;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
	
	private static final Logger logger=LogManager.getLogger(ProductController.class);
	  
	@Autowired
	private ProductServiceImpl productServiceImpl;
		
	@GetMapping("/getAllProducts")
	public ProductGroupListResponse getAllProductGroups() {
		return productServiceImpl.getAllProducts();
	}
	
	
	@GetMapping("/getSubProducts")
	public ProductListResponse getAllSubProductGroups(@RequestParam("productGroupId") Long productGroupId) {
		return productServiceImpl.getAllSubProducts(productGroupId);
	}
	
	@GetMapping("/increaseCount")
	public ApiResponse increaseCount(@RequestParam("productId") Long productId) {
		return productServiceImpl.increaseCount(productId);
	}
	
	@GetMapping("/overView")
	public ProductGroupListResponse overView() {
		return productServiceImpl.overView();
	}
	
	
	@GetMapping("/getProductDetails")
	public ProductDetailsByProduct getProductDetails(@RequestParam Long productId) {
		logger.info("Enter into controller class");
		return productServiceImpl.getProductDetails(productId);
		
		
		
		
	}
	
	

}
