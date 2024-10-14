package com.category_product.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.category_product.model.Product;
import com.category_product.service.ProductService;
import com.category_product.service.categoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	
	 @Autowired
	    private ProductService productService;

	   
	    @GetMapping
	    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) {
	        return productService.findAll(PageRequest.of(page, 10));
	    }

	 
	    @GetMapping("/allproduct")
	    public List<Product> getAllProducts() {
	        return productService.getAllProducts();
	    }

	  
	    @GetMapping("/{id}")
	    public Optional<Product> getProductById(@PathVariable Long id) {
	        return productService.getProductid(id);
	    }

	   
	    @PostMapping("/addproduct")
	    public Product createProduct(@RequestBody Product product) {
	        return productService.saveProduct(product);
	    }

	  
	    @PutMapping("/updateproduct/{id}")
	    public Product updateProduct(@PathVariable Long id, @RequestBody Product productData) {
	        Product product = productService.getProductid(id).orElseThrow();
	        product.setName(productData.getName());
	       
	        return productService.saveProduct(product);
	    }

	 
	    @DeleteMapping("/deleteproduct/{id}")
	    public void deleteProduct(@PathVariable Long id) {
	        productService.deleteProductBy(id);
	    }

	}


