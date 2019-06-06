package com.hcl.ing.product.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ing.product.app.entity.ProductGroup;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {
	
	
	
	@Query(value = "select pg.product_group_id, pg.product_group_name,count(p.product_id) from product p inner join product_group pg on pg.product_group_id=p.product_group_id " + 
			"group by pg.product_group_id",nativeQuery = true)
	public List<Object[]> getAllProducts();
	
	@Query(value = "select pg.product_group_id, pg.product_group_name,sum(p.count) from product p inner join product_group pg on pg.product_group_id=p.product_group_id " + 
			"group by pg.product_group_id",nativeQuery = true)
	public List<Object[]> overView();
	
	

}
