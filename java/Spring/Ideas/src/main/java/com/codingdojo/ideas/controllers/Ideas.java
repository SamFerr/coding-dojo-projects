package com.codingdojo.ideas.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.ideas.models.Idea;
import com.codingdojo.ideas.services.IdeaService;
import com.codingdojo.ideas.services.UserService;

@Controller
public class Ideas {

	private IdeaService ideaService;
	private UserService userService;
	
    public Ideas(IdeaService ideaService, UserService userService) {
        this.ideaService = ideaService;
        this.userService = userService;
    }
	
    @PostMapping("/create_idea")
    public String create(Model model, Principal principal, @Valid @ModelAttribute("newIdea") Idea content, BindingResult result) {
        if (result.hasErrors()) {
        	String username = principal.getName();
        	model.addAttribute("currentUser", userService.findByUsername(username));
        	return "homePage.jsp";
    	} else {
    		ideaService.createIdea(content);
    		return "redirect:/bright_ideas";
    	}
    }
    
    @RequestMapping("/like/{iD}/{userId}")
    public String likeIdea(@PathVariable("iD") Long ideaId, @PathVariable("userId") Long userId) {
    	ideaService.likeIdea(ideaId, userId);
    	return "redirect:/bright_ideas";
    }
    
    @RequestMapping("/bright_ideas/{iD}")
    public String viewIdea(@PathVariable("iD") Long ideaId, Model model) {
		model.addAttribute("currentIdea", ideaService.findById(ideaId));
    	return "displayPage.jsp";
    }


}
