package com.hcl.ing.product.app.dto;

import java.io.Serializable;

import com.hcl.ing.product.app.entity.Product;

public class ProductDetailsDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long productDetailsId;
	private String interestRate;
	private String percentage;
	private String special;
	private String withdrawl;
	private String minInvestment;
	private String maxInvestment;
	private String duration;
	private Product product;

	public Long getProductDetailsId() {
		return productDetailsId;
	}

	public void setProductDetailsId(Long productDetailsId) {
		this.productDetailsId = productDetailsId;
	}

	public String getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getWithdrawl() {
		return withdrawl;
	}

	public void setWithdrawl(String withdrawl) {
		this.withdrawl = withdrawl;
	}

	public String getMinInvestment() {
		return minInvestment;
	}

	public void setMinInvestment(String minInvestment) {
		this.minInvestment = minInvestment;
	}

	public String getMaxInvestment() {
		return maxInvestment;
	}

	public void setMaxInvestment(String maxInvestment) {
		this.maxInvestment = maxInvestment;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
