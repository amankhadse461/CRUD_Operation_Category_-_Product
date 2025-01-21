package com.app.service;


import org.springframework.data.domain.Page;
import com.app.model.Category;


public interface CategoryService {

	Category addCategory(Category category);

	Category getCategoryById(int id);

	Category updateCategory(int id, Category category);

	void deleteCategory(int id);

	Page<Category> getAllCategories(int num, int size);

}
