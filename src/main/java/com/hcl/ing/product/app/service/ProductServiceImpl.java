package com.hcl.ing.product.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.product.app.dto.ProductDetailsByProduct;
import com.hcl.ing.product.app.dto.ProductDetailsDto;
import com.hcl.ing.product.app.entity.ProductDetails;
import com.hcl.ing.product.app.repository.ProductDetailsRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDetailsRepository productDetailsRepository;

	@Override
	public ProductDetailsByProduct getProductDetails(Long productId) {

		List<Object[]> productDetails = productDetailsRepository.findByProduct(productId);

		ProductDetailsByProduct prodDetails = new ProductDetailsByProduct();
		List<ProductDetailsDto> details = new ArrayList<ProductDetailsDto>();

		if (productDetails != null) {

			for (Object[] obj : productDetails) {
				ProductDetails detail = (ProductDetails) obj[0];
				ProductDetailsDto detailsDto = new ProductDetailsDto();
				detailsDto.setDuration(detail.getDuration());
				detailsDto.setInterestRate(detail.getInterestRate());
				detailsDto.setMaxInvestment(detail.getMaxInvestment());
				detailsDto.setMinInvestment(detail.getMinInvestment());
				detailsDto.setPercentage(detail.getPercentage());
				detailsDto.setProduct(detail.getProduct());
				detailsDto.setProductDetailsId(detail.getProductDetailsId());
				detailsDto.setSpecial(detail.getSpecial());
				detailsDto.setWithdrawl(detail.getWithdrawl());
				details.add(detailsDto);

			}
			prodDetails.setProductdetils(details);

		}

		return prodDetails;
	}

}
