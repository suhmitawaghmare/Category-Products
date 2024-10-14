package com.category_product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.category_product.model.Category;

@Repository
public interface categoryRepository extends JpaRepository<Category,Long> {

}
