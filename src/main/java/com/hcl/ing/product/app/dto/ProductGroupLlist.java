package com.hcl.ing.product.app.dto;

import java.io.Serializable;

public class ProductGroupLlist implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long productGroupId;
	
	private String productGroupName;
	
	private Integer count;
	
	public ProductGroupLlist() {
		super();
	}
	
	public ProductGroupLlist(Long productGroupId, String productGroupName, Integer count) {
		super();
		this.productGroupId = productGroupId;
		this.productGroupName = productGroupName;
		this.count = count;
	}

	public Long getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(Long productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getProductGroupName() {
		return productGroupName;
	}

	public void setProductGroupName(String productGroupName) {
		this.productGroupName = productGroupName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	

}
