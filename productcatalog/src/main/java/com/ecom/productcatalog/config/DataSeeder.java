package com.ecom.productcatalog.config;
// initialized some dummy-data

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner{

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	
	public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
		//super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}


	@Override
	public void run(String... args) throws Exception {

		// 1. clear all existing data
		productRepository.deleteAll();
		categoryRepository.deleteAll();
		
		// 2. Create Categories
		Category electronics = new Category();
		electronics.setName("Electronics");
		
		Category clothing = new Category();
		clothing.setName("Clothing");
		
		Category home = new Category();
		home.setName("Home and Kitchen");
//		******************* SAVE_ALL CATEGORIES  *************** //
		categoryRepository.saveAll(Arrays.asList(electronics, home, clothing));
		
		
		// 3. Create Products
		Product phone = new Product();
		phone.setName("SmartPhone");
		phone.setDescription("Latest model smartphone with amazing features");
		phone.setImageUrl("https://placehold.co/600x400");   
		// for now we use placeholder image, but later
		// Amazon-S3 bucket is created where the image is add and that URL here.  
		phone.setPrice(699.99);
		phone.setCategory(electronics);
		
		
		Product laptop = new Product();
		laptop.setName("Laptop");
		laptop.setDescription("High-performance laptop for work and play.");
		laptop.setImageUrl("https://placehold.co/600x400");
		laptop.setPrice(999.99);
		laptop.setCategory(electronics);
		
		
		Product jacket = new Product();
		jacket.setName("Winter");
		jacket.setDescription("Warm and cozy jacket for winter.");
		jacket.setImageUrl("https://placehold.co/600x400");
		jacket.setPrice(139.99);
		jacket.setCategory(clothing);
		
		
		Product blender = new Product();
		blender.setName("Blender");
		blender.setDescription("High-speed blender for smothies and more.");
		blender.setImageUrl("https://placehold.co/600x400");
		blender.setPrice(89.99);
		blender.setCategory(home);

//		******************* SAVE_ALL PRODUCTS  *************** //
		productRepository.saveAll(Arrays.asList(phone, laptop, jacket, blender));
		
		
		
		// 06:13:12
		
	}

	
}
