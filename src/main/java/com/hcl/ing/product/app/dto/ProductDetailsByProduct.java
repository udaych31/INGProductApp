package com.hcl.ing.product.app.dto;

import java.io.Serializable;
import java.util.List;

import com.hcl.ing.product.app.util.ApiResponse;

public class ProductDetailsByProduct extends ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ProductDetailsDto> productdetils;

	public List<ProductDetailsDto> getProductdetils() {
		return productdetils;
	}

	public void setProductdetils(List<ProductDetailsDto> productdetils) {
		this.productdetils = productdetils;
	}

}
