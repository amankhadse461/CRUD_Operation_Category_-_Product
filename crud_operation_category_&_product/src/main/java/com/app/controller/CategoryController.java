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

import com.app.dtos.Message;
import com.app.model.Category;
import com.app.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	Message message;
	
	@GetMapping("/categories")
	public ResponseEntity<Page<Category>> getAllCategories(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "2") int size)
	{
		Page<Category> categorieslists= categoryService.getAllCategories(page,size);
		return new ResponseEntity<Page<Category>>(categorieslists,HttpStatus.OK);
	}

	@PostMapping("/categories")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category category2 =categoryService.addCategory(category);
		return new ResponseEntity<Category>(category2, HttpStatus.ACCEPTED);
	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
		Category category = categoryService.getCategoryById(id);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}

	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
		Category category1 = categoryService.updateCategory(id, category);
		return new ResponseEntity<Category>(category1, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/categories/{id}")
	public ResponseEntity<Message> deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
		String str = "Category delete SucessFully";
		Message mes = message.getMessage(str);
		return new ResponseEntity<Message>(mes, HttpStatus.OK);
	}
	
}
