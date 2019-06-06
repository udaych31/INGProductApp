package com.hcl.ing.product.app.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ing.product.app.dto.ProductGroupListResponse;
import com.hcl.ing.product.app.dto.ProductGroupLlist;
import com.hcl.ing.product.app.dto.ProductList;
import com.hcl.ing.product.app.dto.ProductListResponse;
import com.hcl.ing.product.app.repository.ProductGroupRepository;
import com.hcl.ing.product.app.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	private static final Logger logger=LogManager.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductGroupRepository productGroupRepository; 
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductGroupListResponse getAllProducts() {
		ProductGroupListResponse response=null;
		try {
			List<Object[]> allProducts = productGroupRepository.getAllProducts();
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
			response.setStatus("SUCCESS");
			response.setStatusCode(200);
			
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" getAllProducts :"+e.getMessage());
		}
		
		return response;
	}

	@Override
	public ProductListResponse getAllSubProducts(Long productGroupId) {
		ProductListResponse response=null;
		try {
			List<Object[]> allProducts = productRepository.getAllSubProjects(productGroupId);
			List<ProductList> groupList=new ArrayList<>();
			allProducts.stream().forEach(obj->{
				ProductList list=new ProductList();
				list.setProductId(Long.parseLong(""+obj[0]));
				list.setProductName(""+obj[1]);
				groupList.add(list);
				
			});
			response=new ProductListResponse();
			response.setProductList(groupList);
			response.setStatus("SUCCESS");
			response.setStatusCode(200);
			
		} catch (Exception e) {
			logger.error(this.getClass().getName()+" getAllSubProducts :"+e.getMessage());
		}
		
		return response;
	}
	
}
