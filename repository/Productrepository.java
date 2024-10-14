package com.category_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.category_product.model.Product;

@Repository
public interface Productrepository extends JpaRepository<Product,Long>{

}
