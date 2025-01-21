package com.app.repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.model.Category;

@Repository
public interface CategoryRepositary extends JpaRepository<Category, Integer> {
	
	Category findByCid(int cid);
	
	Category findByName(String name);


}
