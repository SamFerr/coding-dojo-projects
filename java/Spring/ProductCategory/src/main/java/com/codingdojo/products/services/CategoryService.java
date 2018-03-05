package com.codingdojo.products.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.products.models.CategoriesProductsModel;
import com.codingdojo.products.models.CategoryModel;
import com.codingdojo.products.models.ProductModel;
import com.codingdojo.products.repositories.CategoriesProductsRepository;
import com.codingdojo.products.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	private final CategoriesProductsRepository catProdRepository;
	
	public CategoryService(CategoryRepository categoryRepository, CategoriesProductsRepository catProdRepository) {
		this.categoryRepository = categoryRepository;
		this.catProdRepository = catProdRepository;
	}
	
	public CategoryModel createCategory(CategoryModel category) {
		return categoryRepository.save(category);
	}
	
	public CategoryModel getCategory(Long id) {
		return categoryRepository.findOne(id);
	}
	
	public List<CategoryModel> availableCategories(ProductModel product) {
		// As of right now, we do not know how to query single columns 
		// using the spring-data-jpa. I will create a list of name from the 
		// products and execute a not in query with the list in the CrudRepository
		List<String> names = new ArrayList<String>();
		List<CategoryModel> currentCats = product.getCategories();
		
		if(currentCats.isEmpty()) {
			// add empty string if there are not categories. Since an empty array does not have
			// a list of strings, we do not get any categories back;
			names.add("");	
		} else {
			for(CategoryModel c : currentCats) {
				names.add(c.getName());
			}	
		}
			
		List<CategoryModel> cats = categoryRepository.findByNameNotIn(names);
		return cats;
	}
	
	public void addCategory(CategoriesProductsModel catProd) {
		catProdRepository.save(catProd);
	}
}