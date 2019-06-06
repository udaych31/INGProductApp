package com.hcl.ing.product.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_DETAILS")
public class ProductDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productDetailsId;
	
	@Column
	private String interestRate;
	
	@Column
	private String percentage;
	
	@Column
	private String special;
	
	@Column
	private String withdrawl;
	
	@Column
	private String minInvestment;
	
	@Column
	private String maxInvestment;
	
	@Column
	private String duration;
	
	@OneToOne
	private Product product;
	
	public ProductDetails() {
		super();
	}

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
