package com.hcl.ing.product.app.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ing.product.app.dto.ProductGroupListResponse;
import com.hcl.ing.product.app.dto.ProductGroupLlist;
import com.hcl.ing.product.app.dto.ProductList;
import com.hcl.ing.product.app.dto.ProductListResponse;
import com.hcl.ing.product.app.repository.ProductGroupRepository;
import com.hcl.ing.product.app.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

	
	@Mock
	private ProductGroupRepository productGroupRepository;
	
	@Mock
	private ProductRepository productRepository;
	
	@InjectMocks
	private ProductServiceImpl productServiceImpl;
	
	@Test
	public void getAllProductsTest() {
		
		List<Object[]> list=new ArrayList<>();
		Object[] arr= {1,"Mortgage",4};
		Object[] arr2= {2,"Payments",4};
		list.add(arr2);
		list.add(arr);
		
		when(productGroupRepository.getAllProducts()).thenReturn(list);
		ProductGroupListResponse allProducts = productServiceImpl.getAllProducts();
		List<ProductGroupLlist> productsList = allProducts.getProductsList();
		Long actual=Long.valueOf(""+list.size());
		Long expLong=Long.valueOf(""+productsList.size());
		assertEquals(actual, expLong);
		String str1=(String) list.get(0)[1];
		String str2=(String) productsList.get(0).getProductGroupName();
		assertEquals(str1, str2);
		
	}
	

	@Test
	public void getAllSubProductsTest() {
		
		List<Object[]> list=new ArrayList<>();
		Object[] arr= {1,"Bank saving mortgage"};
		Object[] arr1= {2,"Interest-only"};
		Object[] arr2= {3,"Annuity"};
		Object[] arr3= {4,"Linear"};
		list.add(arr2);
		list.add(arr);
		list.add(arr1);
		list.add(arr3);
		
		when(productRepository.getAllSubProjects(1L)).thenReturn(list);
		ProductListResponse allProducts = productServiceImpl.getAllSubProducts(1L);
		List<ProductList> productsList = allProducts.getProductList();
		Long actual=Long.valueOf(""+list.size());
		Long expLong=Long.valueOf(""+productsList.size());
		assertEquals(actual, expLong);
		
	}
	
	
}
