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
import com.codingdojo.products.models.CategoryModel;
import com.codingdojo.products.services.CategoryService;
import com.codingdojo.products.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

	private final ProductService productService;
	private final CategoryService categoryService;
	
	public CategoriesController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/new")
	public String newCategory(@ModelAttribute("category") CategoryModel category) {
		return "/categories/new.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") CategoryModel category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		} else {
			CategoryModel cat = categoryService.createCategory(category);
			String catId = Long.toString(cat.getId());
			return "redirect:/categories/".concat(catId);
		}
	}
	
	@RequestMapping("/{id}")
	public String showCategory(@ModelAttribute("catProd") CategoriesProductsModel catProd, @PathVariable("id") Long id, Model model) {
		CategoryModel category = categoryService.getCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("products", productService.availableProducts(category));
		return "/categories/show.jsp";

	}

	
}
