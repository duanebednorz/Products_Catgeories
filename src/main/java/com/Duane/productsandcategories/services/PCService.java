package com.Duane.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Duane.productsandcategories.models.Category;
import com.Duane.productsandcategories.models.Product;
import com.Duane.productsandcategories.models.ProductsAndCategories;
import com.Duane.productsandcategories.repositories.CategoryRepository;
import com.Duane.productsandcategories.repositories.ProductAndCategoryRepository;
import com.Duane.productsandcategories.repositories.ProductRepository;

@Service
public class PCService {

	private ProductRepository productRepo;
	private CategoryRepository categoryRepo;
	private ProductAndCategoryRepository pcRepo;
	
	public PCService(ProductRepository productRepo, CategoryRepository categoryRepo, ProductAndCategoryRepository pcRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.pcRepo = pcRepo;
	}
	
	public Product createProduct(Product toCreate) {
		return productRepo.save(toCreate);
	}
	
	public Category createCategory(Category toCreate) {
		return categoryRepo.save(toCreate);
	}
	
	public List<Product> getAllProducts() {
		return (List<Product>) productRepo.findAll();
	}
	
	public List<Category> getAllCategories() {
		return (List<Category>) categoryRepo.findAll();
	}
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = this.productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = this.categoryRepo.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	public ProductsAndCategories saveRelationship(ProductsAndCategories pc) {
		return pcRepo.save(pc);
	}
	
	public void deleteProduct(Long id) {
		this.productRepo.deleteById(id);
	}
	
	public void deleteCategory(Long id) {
		this.categoryRepo.deleteById(id);
	}
	
	
	
};
