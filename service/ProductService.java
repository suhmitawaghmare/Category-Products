package com.category_product.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.category_product.model.Product;
import com.category_product.repository.Productrepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
	
	@Autowired
	private Productrepository productrepository;
	
	public List<Product> getAllProducts(){
		
		return productrepository.findAll();
	}
	
	public Optional<Product> getProductid(Long id)
	{
		return productrepository.findById(id);
	}
	
    public  void deleteProductBy(Long id) {
		
    	productrepository.deleteById(id);
	}
    
    
	  public Product saveProduct(Product product) {
	        return  productrepository.save(product);
	    }

	  public Page<Product> findAll(PageRequest pageRequest) {
		    return productrepository.findAll(pageRequest);
		}

	}

	

	
	

		
		
	


