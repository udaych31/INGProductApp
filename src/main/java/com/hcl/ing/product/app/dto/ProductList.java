package com.hcl.ing.product.app.dto;

import java.io.Serializable;

public class ProductList implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long productId;
	
	private String productName;
	
	public ProductList() {
		super();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
