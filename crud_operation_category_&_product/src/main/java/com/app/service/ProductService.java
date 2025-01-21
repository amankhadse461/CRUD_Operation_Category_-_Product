package com.app.service;

import org.springframework.data.domain.Page;

import com.app.model.Product;

public interface ProductService {

	Product addProduct(Product product);

	Product getProductById(int id);

	Product updateProduct(int id, Product product1);

	void deleteProduct(int id);

	Page<Product> getAllProducts(int page, int size);

}
