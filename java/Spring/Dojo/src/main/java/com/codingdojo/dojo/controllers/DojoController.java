package com.codingdojo.dojo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojo.models.DojoModel;
import com.codingdojo.dojo.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/new")
	public String newDojo(@ModelAttribute("dojo") DojoModel dojo) {
		return "/dojos/new.jsp";
	}
	
	@PostMapping("/new")
	public String createDojo(@Valid @ModelAttribute("dojo") DojoModel dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "/dojos/new.jsp";
		}
		else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	
	@RequestMapping("/{id}")
	public String newDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.getDojo(id));
		return "/dojos/show.jsp";
	}
	
}
