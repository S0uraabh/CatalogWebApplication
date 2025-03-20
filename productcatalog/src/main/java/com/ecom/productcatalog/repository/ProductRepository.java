package com.ecom.productcatalog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.productcatalog.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	// MAGIC "AUTOMATICALLY" - by JPA
	List<Product> findByCategoryId(Long categoryId);
	
	// findByCategoryId == JPA naming convention 
	// find == search / fetch
	// ByCategoryId = magic automatically by category id
	// List<Pro>  returning list of products.
}
