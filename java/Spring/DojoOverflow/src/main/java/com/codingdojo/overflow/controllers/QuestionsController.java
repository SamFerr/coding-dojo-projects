package com.codingdojo.overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.Tag;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.overflow.models.AnswersModel;
import com.codingdojo.overflow.models.QuestionsModel;
import com.codingdojo.overflow.models.TagsModel;
import com.codingdojo.overflow.services.QuestionsService;
import com.codingdojo.overflow.services.TagsService;

@Controller
public class QuestionsController {

	private final QuestionsService questionService;
	private final TagsService tagService;
	
	public QuestionsController(QuestionsService questionService, TagsService tagService) {
		this.questionService = questionService;
		this.tagService = tagService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "tags", new CustomCollectionEditor(List.class) {                
	                  
	        public void setAsText(String element) {
	        	// information coming from the form
	        	String[] listOfTagString = element.split(", ");
	        	List<TagsModel> listOfTags = new ArrayList<TagsModel>();
	        	
	        	int maxLength = listOfTagString.length > 2 ? 3 : listOfTagString.length;
	        	
	        	for(int i = 0; i < maxLength; i++) {
	        		listOfTags.add(tagService.findOrCreateTag(listOfTagString[i]));
	        	}
	        	
	        	// set the value of the element to be a list of tags
	        	setValue(listOfTags);
	        }
        }); 
	}
		
	@RequestMapping("/questions")
	public String index(Model model) {
		model.addAttribute("questions", questionService.getAllQuestions());
		return "/questions/dash.jsp";
	}
	
	@RequestMapping("/new")
	public String newQuestion(@ModelAttribute("questionModel") QuestionsModel question) {
		return "/questions/new.jsp";
	}
	
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("questionModel") QuestionsModel question, BindingResult result, @RequestParam("tags") String tags) {
		if(result.hasErrors()) {
			return "/questions/new.jsp";
		}
		else {
			questionService.createQuestion(question);
			return "redirect:/questions";
		}
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, @ModelAttribute("answerModel") AnswersModel answer, Model model) {
		model.addAttribute("question", questionService.findOne(id));
		return "/questions/profile.jsp";
	}
	



}
