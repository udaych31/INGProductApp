package com.hcl.ing.product.app.service;

import com.hcl.ing.product.app.dto.ProductGroupListResponse;
import com.hcl.ing.product.app.dto.ProductListResponse;

public interface ProductService {
	
	public ProductGroupListResponse getAllProducts();
	
	public ProductListResponse getAllSubProducts(Long productGroupId);

}
