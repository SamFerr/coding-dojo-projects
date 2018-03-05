package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class Songs {
	
	private final SongService songService;
	public Songs(SongService songService) {
		this.songService = songService;
	}

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(@ModelAttribute("song") Song song, Model model) {
		model.addAttribute("songs", songService.findAll());
		return "dash.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String topTen(@ModelAttribute("song") Song song, Model model) {
		model.addAttribute("songs", songService.findTop10ByOrderByRatingDesc());
		return "top.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp";			
		}
		else {
			return "redirect:/";
		}
	}
	
	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp";			
		}
		else {
			songService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/search/{artist}")
	public String searchResult(@PathVariable("artist") String artist, Model model) {
		model.addAttribute("artist", artist);
		List<Song> songs = songService.searchByArtist(artist);
		
		// if query returns empty list
		if(songs.isEmpty()) {
			return "redirect:/dashboard";
		} else {
			model.addAttribute("songs", songService.searchByArtist(artist));
			return "search/result.jsp";			
		}
	}
	
}
