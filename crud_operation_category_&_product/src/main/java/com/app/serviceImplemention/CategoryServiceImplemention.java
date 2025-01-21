package com.app.serviceImplemention;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.exceptions.CategoryNotFound;
import com.app.model.Category;
import com.app.model.Product;
import com.app.repositary.CategoryRepositary;
import com.app.service.CategoryService;

@Service
public class CategoryServiceImplemention  implements CategoryService{

	@Autowired
	CategoryRepositary categoryRepositary;

	
	@Override
	public Category addCategory(Category category) {
		 Category category2 = categoryRepositary.save(category);
		 return category2;
	}


	@Override
	public Category getCategoryById(int id) {
		  Category category = categoryRepositary.findByCid(id);
		  if (category!=null) {
			return category;
		}
		  else
		  {
			  throw new CategoryNotFound("Category not Found with Id: "+id);
		  }
		 
	}


	@Override
	public Category updateCategory(int id,Category category1) {
		Category category =  categoryRepositary.findByCid(id);
		if (category!=null) {
			List<Product> productsList = category1.getProductsList();
			category.setProductsList(productsList);
			category.setName(category1.getName());
			categoryRepositary.save(category);
			return category;
		}
		else
		{
			throw new CategoryNotFound("Category not Found with Id: "+id);
		}
		
	}


	@Override
	public void deleteCategory(int id) {
		Category category = categoryRepositary.findByCid(id);
		categoryRepositary.delete(category);
		
	}

	@Override
	public Page<Category> getAllCategories(int num,int size) {
		Pageable pageable = PageRequest.of(num,size);
		return categoryRepositary.findAll(pageable);
	}



	
	
	

}
