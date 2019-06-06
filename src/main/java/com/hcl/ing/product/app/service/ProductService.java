package com.hcl.ing.product.app.service;

import com.hcl.ing.product.app.dto.ProductGroupListResponse;
import com.hcl.ing.product.app.dto.ProductListResponse;
import com.hcl.ing.product.app.util.ApiResponse;

public interface ProductService {
	
	public ProductGroupListResponse getAllProducts();
	
	public ProductListResponse getAllSubProducts(Long productGroupId);
	
	public ApiResponse increaseCount(Long productId);
	
	public ProductGroupListResponse overView();

}
