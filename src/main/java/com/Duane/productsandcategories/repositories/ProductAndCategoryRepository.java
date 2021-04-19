package com.Duane.productsandcategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Duane.productsandcategories.models.ProductsAndCategories;

@Repository
public interface ProductAndCategoryRepository extends CrudRepository<ProductsAndCategories, Long>{
	ProductsAndCategories save(ProductsAndCategories pc);
}
