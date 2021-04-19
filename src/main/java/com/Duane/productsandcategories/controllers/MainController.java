package com.Duane.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Duane.productsandcategories.models.Category;
import com.Duane.productsandcategories.models.Product;
import com.Duane.productsandcategories.models.ProductsAndCategories;
import com.Duane.productsandcategories.services.PCService;

@Controller
public class MainController {
	
private PCService pcServ;
	
	public MainController(PCService pcServ) {
		this.pcServ = pcServ;
	}
//	******Dashboard so I can see everything************
	@GetMapping("/dashboard")
	public String Dashboard(Model model) {
		model.addAttribute("allProducts", pcServ.getAllProducts());
		model.addAttribute("allCategories", pcServ.getAllCategories());
		return "Dashboard.jsp";
	}
//	******View One Product view************
	@GetMapping("/products/{id}")
	public String viewOneProduct(@PathVariable("id") Long id, Model model) {
		Product myProduct = this.pcServ.findProduct(id);
    	model.addAttribute("product", myProduct);
    	model.addAttribute("allCategories", pcServ.findUsedCat(this.pcServ.findProduct(id)));
		return "ViewOneProduct.jsp";
	}
//	******View One Product view************
	@GetMapping("/categories/{id}")
	public String viewOneCategory(@PathVariable("id") Long id, Model model) {
		Category myCategory = this.pcServ.findCategory(id);
    	model.addAttribute("thisCategory", myCategory);
    	model.addAttribute("allProducts", pcServ.findUsedProd(this.pcServ.findCategory(id)));
		return "ViewOneCategory.jsp";
	}

	
//	Route for new products form*************************
	@GetMapping("/products/new")
	public String newProduct(Model model) {
		model.addAttribute("newProduct", new Product()); 
		model.addAttribute("allProducts", pcServ.getAllProducts()); // displays all products
		return "NewProducts.jsp";
	}
	
	@PostMapping("/product/create")
	public String createProduct(@Valid @ModelAttribute("newProduct") Product newProduct, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			// still display notes if validation error
			System.out.println(result.getAllErrors());
			model.addAttribute("allProducts", pcServ.getAllProducts()); 
			return "NewProducts.jsp";
		}
		// otherwise create a note and redirect back
		pcServ.createProduct(newProduct);
		return "redirect:/dashboard";
	}
//	Route for new Categories form***********************
	@GetMapping("/categories/new")
	public String newCategory(Model model) {
		model.addAttribute("newCategory", new Product()); 
		model.addAttribute("allProducts", pcServ.getAllProducts()); // displays all products
		return "NewCategories.jsp";
	}
	
	@PostMapping("/category/create")
	public String createCategory(@Valid @ModelAttribute("newCategory") Category newCategory, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			// still display notes if validation error
			System.out.println(result.getAllErrors());
			model.addAttribute("allCategories", pcServ.getAllCategories()); 
			return "NewCategories.jsp";
		}
		// otherwise create a note and redirect back
		pcServ.createCategory(newCategory);
		return "redirect:/dashboard";
	}
	
	
//	Route for M:M join
	@PostMapping("/addCategory")
	public String addCatgeory(@RequestParam(value="product_id") Long product_id,
			@RequestParam(value="category_id") Long category_id) {
	
		Product p = pcServ.findProduct(product_id);
		Category c = pcServ.findCategory(category_id);
		
		ProductsAndCategories pc = new ProductsAndCategories(p, c);
		
		if(!p.getCategories().contains(c)) {
		pcServ.saveRelationship(pc);
		}
		
		return "redirect:/addCategory";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestParam(value="product_id") Long product_id,
			@RequestParam(value="category_id") Long category_id) {
	
		Product p = pcServ.findProduct(product_id);
		Category c = pcServ.findCategory(category_id);
		
		ProductsAndCategories pc = new ProductsAndCategories(p, c);
		
		if(!p.getCategories().contains(c)) {
			pcServ.saveRelationship(pc);
		}
		
		
		return "redirect:/addProduct";
	}
	
	
//	last line**************************
};

