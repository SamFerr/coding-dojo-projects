package com.codingdojo.driver.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.driver.models.Person;
import com.codingdojo.driver.services.DriverService;

@Controller
public class PersonController {
	
	private final DriverService driverService;
	
	public PersonController(DriverService driverService) {
		this.driverService = driverService;
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/persons/new.jsp";
	}
	
	@PostMapping("/persons/new")
	public String createLicense(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "/persons/new.jsp";
		}
		else {
			driverService.addPerson(person);
			return "redirect:/licenses/new";
		}
	}
	
	@RequestMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", driverService.getPerson(id));
		return "/persons/show.jsp";
	}

}
