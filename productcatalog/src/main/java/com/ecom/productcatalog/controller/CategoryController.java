package com.ecom.productcatalog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {
	
	private CategoryService categoryService;
	
	// to make sure it initialized  
	public CategoryController(CategoryService categoryService) {
		//super();
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public List<Category> getAllCategoryes(){
		return categoryService.getAllCategories();
	}

	
	
	
}
