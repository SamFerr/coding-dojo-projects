package com.codingdojo.overflow.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.overflow.models.AnswersModel;
import com.codingdojo.overflow.services.AnswersService;

@Controller
public class AnswersController {
	
	private final AnswersService answerService;
	
	public AnswersController(AnswersService answerService) {
		this.answerService = answerService;
	}
	
	@PostMapping("/answers")
	public String createAnswer(@Valid @ModelAttribute("answerModel") AnswersModel answer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("question", answer.getQuestion());
			return "/questions/profile.jsp";
		}
		else {
			answerService.createAnswer(answer);
			String questionId = String.valueOf(answer.getQuestion().getId());
			return "redirect:/questions/".concat(questionId);
		}
	}

}
