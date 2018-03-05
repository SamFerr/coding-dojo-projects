package com.codingdojo.products.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.products.models.CategoryModel;
import com.codingdojo.products.models.ProductModel;
import com.codingdojo.products.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ProductModel createProduct(ProductModel product) {
		return productRepository.save(product);
	}
	
	public ProductModel getProduct(Long id) {
		return productRepository.findOne(id);
	}
	
	public List<ProductModel> availableProducts(CategoryModel category) {
		// As of right now, we do not know how to query single columns 
		// using the spring-data-jpa. I will create a list of name from the 
		// products and execute a not in query with the list in the CrudRepository
		List<String> names = new ArrayList<String>();
		List<ProductModel> currentProds = category.getProducts();
		
		if(currentProds.isEmpty()) {
			// add empty string if there are not categories. Since an empty array does not have
			// a list of strings, we do not get any categories back;
			names.add("");	
		} else {
			for(ProductModel p : currentProds) {
				names.add(p.getName());
			}	
		}
			
		List<ProductModel> prods = productRepository.findByNameNotIn(names);
		return prods;
	}
	
//	public void addCategory(CategoriesProducts catProd) {
//		catProdRepository.save(catProd);
//	}	
}