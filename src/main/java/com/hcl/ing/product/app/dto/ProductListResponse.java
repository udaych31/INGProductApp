package com.hcl.ing.product.app.dto;

import java.io.Serializable;
import java.util.List;

import com.hcl.ing.product.app.util.ApiResponse;

public class ProductListResponse extends ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<ProductList> productList;
	
	public ProductListResponse() {
		super();
	}

	public List<ProductList> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductList> productList) {
		this.productList = productList;
	}

	
}
