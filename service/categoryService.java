package com.category_product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.category_product.model.Category;
import com.category_product.model.Product;
import com.category_product.repository.categoryRepository;

@Service
public class categoryService {
	

    @Autowired
    private static categoryRepository categoryRepository;
    public List<Category> getAllCategory(){
		
		return categoryRepository.findAll();
	}
	
	public Optional<Category> getCategorytid(Long id)
	{
		return categoryRepository.findById(id);
	}
	
    public  void deleteCategoryBy(Long id) {
		
    	categoryRepository.deleteById(id);
	}
    
    
	  public Category saveCategory(Category category) {
	        return  categoryRepository.save(category);
	    }
    }
	


