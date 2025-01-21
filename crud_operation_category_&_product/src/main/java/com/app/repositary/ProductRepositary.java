package com.app.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Product;

@Repository
public interface ProductRepositary extends JpaRepository<Product, Integer> {
	
	Product findByPid(int id);

}
