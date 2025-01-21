package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Product;
import com.app.service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product,int id) 
	{
		Product product2 = productService.addProduct(product);
		return new ResponseEntity<Product>(product2,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable  int id )
	{
		Product productById = productService.getProductById(id);
		return new ResponseEntity<Product>(productById,HttpStatus.OK);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> upadateProduct(@PathVariable int id,@RequestBody Product product1)
	{
		Product product = productService.updateProduct(id,product1);
		return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id)
	{
		productService.deleteProduct(id);
		return new ResponseEntity<String>("Product deleted!",HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "2") int size)
	{
		Page<Product> page2 = productService.getAllProducts(page,size);
		return new ResponseEntity<Page<Product>>(page2,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
}