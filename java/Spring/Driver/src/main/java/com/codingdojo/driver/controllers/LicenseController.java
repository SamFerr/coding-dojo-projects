package com.codingdojo.driver.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.driver.models.License;
import com.codingdojo.driver.services.DriverService;

@Controller
public class LicenseController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	private final DriverService driverService;
	
	public LicenseController(DriverService driverService) {
		this.driverService = driverService;
	}

	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("persons", driverService.allPersons());
		return "/licenses/new.jsp";
	}
	
	@PostMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute License license, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("persons", driverService.allPersons());
			return "/licenses/new.jsp";
		}
		else {
			License lic = driverService.addLicense(license);
			String personId = Long.toString(lic.getPerson().getId());
			return "redirect:/persons/".concat(personId);
		}
	}
}
