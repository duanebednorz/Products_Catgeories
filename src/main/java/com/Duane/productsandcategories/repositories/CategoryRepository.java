package com.Duane.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Duane.productsandcategories.models.Category;
import com.Duane.productsandcategories.models.Product;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	List<Category> findByProductsNotContains(Product products);
}