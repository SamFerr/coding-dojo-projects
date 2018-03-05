package com.codingdojo.pagination.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.pagination.services.ApiService;

@Controller
public class ApiCtrl {
	private final ApiService apiService;
	
	public ApiCtrl(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/pages/{pageNumber}")
	public String index(Model model, @PathVariable("pageNumber") int pageNumber) {
		Page<Object[]> dojoAndNinjas = apiService.joinDojosAndNinjas(pageNumber - 1);
		int totalPages = dojoAndNinjas.getTotalPages();

		model.addAttribute("table", dojoAndNinjas);
		model.addAttribute("totalPages", totalPages);

		return "index.jsp";
	}
}