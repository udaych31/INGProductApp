package com.hcl.ing.product.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.ing.product.app.entity.ProductDetails;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {
	
	@Query(value="select * from product_details where product_product_Id=:productId",nativeQuery=true)
	List<ProductDetails> findByProduct(@Param(value="productId") Long productId);

}
