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
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ideas.models.Idea;
import com.codingdojo.ideas.models.User;
import com.codingdojo.ideas.services.IdeaService;
import com.codingdojo.ideas.services.UserService;
import com.codingdojo.ideas.validator.UserValidator;

@Controller
public class Users {
	
	private UserService userService;
	private IdeaService ideaService;
	private UserValidator userValidator;
	
	public Users(UserService userService, UserValidator userValidator, IdeaService ideaService) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.ideaService = ideaService;
	}

	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		}
		userService.saveWithUserRole(user);
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
//	Remember, when the credentials are wrong, Spring Security redirect the client to the /login?error url. Furthermore, when a client logs out via the form in our homePage.jsp file, Spring Security redirects them to /login?logout url. Therefore, all we do is set a couple of optional request parameters, check for their existence, and add messages accordingly.
	public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		if(error!=null) {
			model.addAttribute("errorMessage", "Invalid Credentials, please try again.");
		}
		if (logout!=null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}
		return "loginPage.jsp";
	}
	
	@RequestMapping("/bright_ideas")
	public String home(Principal principal, Model model, @ModelAttribute("newIdea") Idea idea) {
//		Our home method accepts GET requests for "/" and "/home" urls. After a successful authentication, we are able to get the name of our principal (current user) via the .getName() method. 
		String username = principal.getName();
		model.addAttribute("currentUser", userService.findByUsername(username));
		model.addAttribute("ideas", ideaService.findAllIdeas());
		return "homePage.jsp";
	}
	
	@RequestMapping("/users/{userId}")
	public String viewUser(@PathVariable("userId") Long id, Model model) {
    	User clickUser = userService.findById(id);
        model.addAttribute("clickedUser", clickUser);
    	return "userPage.jsp";
	}
	
}
