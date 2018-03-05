package com.codingdojo.products.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.products.models.CategoriesProductsModel;
import com.codingdojo.products.models.ProductModel;
import com.codingdojo.products.services.CategoryService;
import com.codingdojo.products.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductsController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/new")
	public String newProduct(@ModelAttribute("product") ProductModel products) {
		return "/products/new.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") ProductModel product, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/new.jsp";
		} else {
			ProductModel prod = productService.createProduct(product);
			String prodId = Long.toString(prod.getId());
			return "redirect:/products/".concat(prodId);
		}
	}
	
	@RequestMapping("/{id}")
	public String showProduct(@ModelAttribute("catProd") CategoriesProductsModel catProd, @PathVariable("id") Long id, Model model) {
		ProductModel product = productService.getProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.availableCategories(product));
		return "/products/show.jsp";
	}
	
	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("catProd") CategoriesProductsModel catProd) {
		categoryService.addCategory(catProd);
		String prodId = Long.toString(catProd.getProduct().getId());
		return "redirect:/products/".concat(prodId);
	}

}
