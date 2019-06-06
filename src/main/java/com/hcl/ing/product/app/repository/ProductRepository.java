package com.hcl.ing.product.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.ing.product.app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(value = "select p.product_id,p.product_name from product p where p.product_group_id=:productGroupId",nativeQuery = true)
	public List<Object[]> getAllSubProjects(@Param("productGroupId") Long productGroupId);
	
	public Product findByProductId(Long productId);

}
