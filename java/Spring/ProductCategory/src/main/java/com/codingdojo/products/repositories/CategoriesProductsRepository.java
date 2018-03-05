package com.codingdojo.products.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.products.models.CategoriesProductsModel;

@Repository
public interface CategoriesProductsRepository extends CrudRepository<CategoriesProductsModel, Long> {

}
