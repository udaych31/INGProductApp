package com.hcl.ing.product.app.dto;

import java.io.Serializable;
import java.util.List;

import com.hcl.ing.product.app.dto.ProductGroupLlist;
import com.hcl.ing.product.app.util.ApiResponse;

public class ProductGroupListResponse extends ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	List<ProductGroupLlist> productsList;
	
	public ProductGroupListResponse() {
		super();
	}

	public List<ProductGroupLlist> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<ProductGroupLlist> productsList) {
		this.productsList = productsList;
	}
	
	
}
