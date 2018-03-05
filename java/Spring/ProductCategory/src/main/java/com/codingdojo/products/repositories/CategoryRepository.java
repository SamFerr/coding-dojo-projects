package com.codingdojo.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.products.models.CategoryModel;

public interface CategoryRepository extends CrudRepository<CategoryModel, Long>{
	
	List<CategoryModel> findByNameNotIn(List<String> name);
	
}
