package com.hcl.ing.product.app.service;

import com.hcl.ing.product.app.dto.ProductDetailsByProduct;

public interface ProductService {

	public ProductDetailsByProduct getProductDetails(Long productId);

}
