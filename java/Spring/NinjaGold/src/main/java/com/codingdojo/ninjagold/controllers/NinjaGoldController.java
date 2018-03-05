package com.codingdojo.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer gold = (Integer) session.getAttribute("gold");
		ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
		
		if(gold==null) session.setAttribute("gold", 0);
		if(messages==null) session.setAttribute("messages", new ArrayList<String>());
		return "index.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String makeGold(HttpSession session, @RequestParam("building") String building) {
		Integer gold = (Integer) session.getAttribute("gold");
		ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
		Random thing = new Random();
		String msg = "";
		int goldGenerated = 0;
		
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM'/'dd'/'yyyy h:mm a");
		String nowParsedDate = date.format(formatter);
		
		if(building.equals("farm")){
			goldGenerated = thing.nextInt(11) + 10;
			msg = "You entered a farm and earned " + goldGenerated + " gold. " + nowParsedDate;
		}
		
		if(building.equals("house")){
			goldGenerated = thing.nextInt(4) + 2;
			msg = "You entered a house and earned " + goldGenerated + " gold. " + nowParsedDate;
		}
		
		if(building.equals("cave")){
			goldGenerated = thing.nextInt(6) + 5;
			msg = "You entered a cave and earned " + goldGenerated + " gold. " + nowParsedDate;
		}
		
		if(building.equals("casino")){
			goldGenerated = thing.nextInt(101) - 50;
			if(goldGenerated < 0) {
				msg = "You entered a casino and lost " + goldGenerated + " gold... Ouch. " + nowParsedDate;
			}
			else {
				msg = "You entered a casino and earned " + goldGenerated + " gold. " + nowParsedDate;
			}
		}
		
		messages.add(0, msg);
		gold += goldGenerated;
		session.setAttribute("messages", messages);
		session.setAttribute("gold", gold);
		
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String resetGame(HttpSession session) {
		session.setAttribute("gold", null);
		session.setAttribute("messages", null);
		return "redirect:/";
	}
}