package com.codingdojo.dojo.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojo.models.NinjaModel;
import com.codingdojo.dojo.services.DojoService;
import com.codingdojo.dojo.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {

	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public NinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/new")
	public String newNinjas(@ModelAttribute("ninja") NinjaModel ninja, Model model) {
		model.addAttribute("dojos", dojoService.getAll());
		return "/ninjas/new.jsp";
	}
	
	@PostMapping("/new")
	public String createNinja(@Valid @ModelAttribute("ninja") NinjaModel ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "/ninjas/new.jsp";
		}
		else {
			NinjaModel dude = ninjaService.createNinja(ninja);
			String dojoId = Long.toString(dude.getDojo().getId());
			return "redirect:/dojos/".concat(dojoId);
		}
	}
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
	    // we have to subtract 1 because the Pages iterable is 0 indexed. This is for our links to be able to show from 1...pageMax, instead of 0...pageMax - 1.
	    Page<NinjaModel> ninjas = ninjaService.ninjasPerPage(pageNumber - 1);
	    // total number of pages that we have
	    int totalPages = ninjas.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("ninjas", ninjas);
	    return "ninjas.jsp";
	}
	
}
