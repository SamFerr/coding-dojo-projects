package com.codingdojo.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.LanguageModel;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<LanguageModel> allLanguages() {
		return languageRepository.findAll();
	}
	
	public void addLanguage(LanguageModel lang) {
		languageRepository.save(lang);
	}
	
	public LanguageModel getLanguage(Long id) {
		return languageRepository.findOne(id);
	}
	
	public void updateLanguage(LanguageModel lang) {
		languageRepository.save(lang);
	}
	
	public void deleteLanguage(Long id) {
		languageRepository.delete(id);
	}	
}