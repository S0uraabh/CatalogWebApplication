package com.ecom.productcatalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.productcatalog.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> { 

}