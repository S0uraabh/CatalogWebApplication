package com.ecom.productcatalog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.repository.CategoryRepository;

@Service
public class CategoryService {

	private CategoryRepository categoryRepository;

	// initialized
	public CategoryService(CategoryRepository categoryRepository) {
		//super();
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	

}
