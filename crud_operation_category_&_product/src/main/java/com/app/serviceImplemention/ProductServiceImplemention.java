package com.app.serviceImplemention;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.exceptions.ProductNotFound;
import com.app.model.Category;
import com.app.model.Product;
import com.app.repositary.CategoryRepositary;
import com.app.repositary.ProductRepositary;
import com.app.service.ProductService;

@Service
public class ProductServiceImplemention implements ProductService {

	@Autowired
	ProductRepositary productRepositary;
	
	@Autowired
	CategoryRepositary categoryRepositary;
	

	@Override
	public Product addProduct(Product product) {
		Product product2 = productRepositary.save(product);
		return product2;
		
		
	}

	@Override
	public Product getProductById(int id) {
		Product product = productRepositary.findByPid(id);
		if (product!=null) {
			return product;
		}
		else {
			throw new ProductNotFound("Product not found with Id: "+id);
		}
	}

	@Override
	public Product updateProduct(int id,Product product) {
		Product product22 = productRepositary.findByPid(id);
		if (product!=null) {
			product22.setPrice(product.getPrice());
			productRepositary.save(product22);
			return product22;
		}
		else
		{
			throw new ProductNotFound("Product not found with Id: "+id);
		}
		
	}

	@Override
	public void deleteProduct(int id) {
		Product product = productRepositary.findByPid(id);
		Category category = product.getCategory();
		List<Product> list = category.getProductsList();
		Iterator<Product> itr = list.iterator();
		while (itr.hasNext()) {
				Product product1 = itr.next();
				if (product1.equals(product)) {
					itr.remove();
				}
			
		}
		categoryRepositary.save(category);
		productRepositary.delete(product);
	}

	@Override
	public Page<Product> getAllProducts(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return productRepositary.findAll(pageable);
	}
	
	 
		
	 

}
