package com.codingdojo.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.languages.models.LanguageModel;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String index(@ModelAttribute("language") LanguageModel language, Model model) {
		model.addAttribute("languages", languageService.allLanguages());
		return "index.jsp";
	}

	@PostMapping("/languages")
	public String createLanguages(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("languages", languageService.allLanguages());
			return "index.jsp";
		}
		else {
			languageService.addLanguage(language);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/languages/{id}")
	public String showLanguage(Model model, @PathVariable("id") Long id) {
		LanguageModel lang = languageService.getLanguage(id);
		model.addAttribute("id", id);
		model.addAttribute("language", lang);
		return "show.jsp";
	}
	
	@RequestMapping("/languages/edit/{id}")
	public String editLanguage(Model model, @PathVariable("id") Long id) {
		LanguageModel lang = languageService.getLanguage(id);
		model.addAttribute("id", id);
		model.addAttribute("language", lang);
		return "edit.jsp";
	}
	
	@PostMapping("/languages/update/{id}")
	public String updateLanguage(@Valid @ModelAttribute("language") LanguageModel language, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			languageService.updateLanguage(language);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/languages/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/";
	}
	
	
}
