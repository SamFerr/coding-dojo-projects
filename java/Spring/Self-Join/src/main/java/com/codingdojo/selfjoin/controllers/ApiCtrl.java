package com.codingdojo.selfjoin.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.selfjoin.models.Employee;
import com.codingdojo.selfjoin.services.ApiService;

@Controller
public class ApiCtrl {
	private final ApiService apiService;
	
	public ApiCtrl(ApiService apiService) {
		this.apiService = apiService;
	}
	
	@RequestMapping("/")
	public String index() {
		List<Employee> employeez = apiService.findEmployees((long) 1);
		Employee managa = apiService.findManager((long) 4);
		
		// all employees under manager with id 1
		for(Employee emoney : employeez)
			System.out.println(emoney.getFirstName());
		
		// manager of employee with id 4
		System.out.println(managa.getFirstName());
		return "index.jsp";
	}
	
	@RequestMapping("/createEmployees")
	public String createEmployees() {
		apiService.createEmployees();
		return "index.jsp";
	}
	
	@RequestMapping("/createManagers")
	public String createManagers() {
		apiService.createManagers();
		return "index.jsp";
	}
}