package com.hcl.ing.product.app.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.product.app.dto.ProductDetailsByProduct;
import com.hcl.ing.product.app.dto.ProductDetailsDto;
import com.hcl.ing.product.app.dto.ProductGroupListResponse;
import com.hcl.ing.product.app.dto.ProductGroupLlist;
import com.hcl.ing.product.app.dto.ProductList;
import com.hcl.ing.product.app.dto.ProductListResponse;
import com.hcl.ing.product.app.entity.Product;
import com.hcl.ing.product.app.entity.ProductDetails;
import com.hcl.ing.product.app.repository.ProductDetailsRepository;
import com.hcl.ing.product.app.repository.ProductGroupRepository;
import com.hcl.ing.product.app.repository.ProductRepository;
import com.hcl.ing.product.app.util.ApiResponse;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	private static final Logger logger=LogManager.getLogger(ProductServiceImpl.class);
	
	private static final String SUCCESS="SUCCESS";
	


	@Autowired
	private ProductGroupRepository productGroupRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductDetailsRepository productDetailsRepository;

	@Override
	public ProductGroupListResponse getAllProducts() {
		ProductGroupListResponse response = null;
		try {
			List<Object[]> allProducts = productGroupRepository.getAllProducts();
			List<ProductGroupLlist> groupList = new ArrayList<>();
			allProducts.stream().forEach(obj -> {
				ProductGroupLlist list = new ProductGroupLlist();
				list.setProductGroupId(Long.parseLong("" + obj[0]));
				list.setProductGroupName("" + obj[1]);
				list.setCount(Integer.parseInt("" + obj[2]));
				groupList.add(list);

			});
			response = new ProductGroupListResponse();
			response.setProductsList(groupList);
			response.setStatus(SUCCESS);
			response.setStatusCode(200);

		} catch (Exception e) {
			logger.error(this.getClass().getName() + " getAllProducts :" + e.getMessage());
		}

		return response;
	}


	@Override
	public ProductDetailsByProduct getProductDetails(Long productId) {

		logger.info("enter into getProductDetails method");
		ProductDetailsByProduct prodDetails = null;

		List<ProductDetails> productDetails = productDetailsRepository.findByProduct(productId);
		try {

			List<ProductDetailsDto> details = new ArrayList<ProductDetailsDto>();

			if (productDetails != null) {

				for (ProductDetails obj : productDetails) {

					ProductDetailsDto detailsDto = new ProductDetailsDto();
					detailsDto.setDuration(obj.getDuration());
					detailsDto.setInterestRate(obj.getInterestRate());
					detailsDto.setMaxInvestment(obj.getMaxInvestment());
					detailsDto.setMinInvestment(obj.getMinInvestment());
					detailsDto.setPercentage(obj.getPercentage());
					detailsDto.setSpecial(obj.getSpecial());
					detailsDto.setWithdrawl(obj.getWithdrawl());
					details.add(detailsDto);

				}
				increaseCount(productId);
				prodDetails = new ProductDetailsByProduct();
				prodDetails.setProductdetils(details);
				prodDetails.setStatus(SUCCESS);
				prodDetails.setStatusCode(200);
				
			}
		} catch (Exception e) {
			logger.error(logger.getClass().getName() + "  get all products" + e.getMessage());
		}

		return prodDetails;
	}

	@Override
	public ProductListResponse getAllSubProducts(Long productGroupId) {
		ProductListResponse response = null;
		try {
			List<Object[]> allProducts = productRepository.getAllSubProjects(productGroupId);
			List<ProductList> groupList = new ArrayList<>();
			allProducts.stream().forEach(obj -> {
				ProductList list = new ProductList();
				list.setProductId(Long.parseLong("" + obj[0]));
				list.setProductName("" + obj[1]);
				groupList.add(list);

			});
			response = new ProductListResponse();
			response.setProductList(groupList);
			response.setStatus(SUCCESS);
			response.setStatusCode(200);

		} catch (Exception e) {
			logger.error(this.getClass().getName() + " getAllSubProducts :" + e.getMessage());
		}

		return response;
	}
	
	@Override
	public ApiResponse increaseCount(Long productId) {
		ApiResponse response=null;
		try {
			Product product = productRepository.findByProductId(productId);
			if(product!=null) {
				Integer count = product.getCount();
				Integer actual=count+1;
				product.setCount(actual);
				productRepository.save(product);
				response=new ApiResponse();
				response.setStatus(SUCCESS);
				response.setStatusCode(200);
			}
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" overViewCount :"+e.getMessage());
		}
		
		return response;
	}
	
	@Override
	public ProductGroupListResponse overView() {
		ProductGroupListResponse response=null;
		try {
			List<Object[]> allProducts = productGroupRepository.overView();
			List<ProductGroupLlist> groupList=new ArrayList<>();
			allProducts.stream().forEach(obj->{
				ProductGroupLlist list=new ProductGroupLlist();
				list.setProductGroupId(Long.parseLong(""+obj[0]));
				list.setProductGroupName(""+obj[1]);
				list.setCount(Integer.parseInt(""+obj[2]));
				groupList.add(list);
				
			});
			response=new ProductGroupListResponse();
			response.setProductsList(groupList);
			response.setStatus(SUCCESS);
			response.setStatusCode(200);
			
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" getAllProducts :"+e.getMessage());
		}
		
		return response;

	}
	
}
