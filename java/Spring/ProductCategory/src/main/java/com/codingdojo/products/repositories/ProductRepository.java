package com.codingdojo.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.products.models.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel, Long>{
	List<ProductModel> findByNameNotIn(List<String> name);
}