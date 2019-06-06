package com.hcl.ing.product.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ing.product.app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
