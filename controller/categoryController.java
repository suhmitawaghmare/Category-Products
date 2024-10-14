package com.category_product.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.category_product.model.Category;
import com.category_product.model.Product;
import com.category_product.repository.categoryRepository;
import com.category_product.service.categoryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")

public class categoryController
{
	 @Autowired
	    private categoryRepository categoryRepository;

	    @GetMapping
	    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0") int page) {
	        return categoryRepository.findAll(PageRequest.of(page, 10));
	    }

	    @PostMapping("/addcategory")
	    public Category createCategory(@RequestBody Category category) {
	        return categoryRepository.save(category);
	    }

	    @GetMapping("/{id}")
	    public Optional<Category> getCategoryById(@PathVariable Long id) {
	        return categoryRepository.findById(id);
	    }

	    @PutMapping("/updatecategory/{id}")
	    public Category updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
	        Category category = categoryRepository.findById(id).orElseThrow();
	        category.setName(categoryDetails.getName());
	        return categoryRepository.save(category);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCategory(@PathVariable Long id) {
	        categoryRepository.deleteById(id);
	    }

	}

