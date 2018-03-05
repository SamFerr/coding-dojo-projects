package com.codingdojo.overflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.QuestionsModel;
import com.codingdojo.overflow.repositories.AnswersRepository;
import com.codingdojo.overflow.repositories.QuestionsRepository;

@Service
public class QuestionsService {
	private final QuestionsRepository questionRepo;
	
	public QuestionsService(QuestionsRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	public List<QuestionsModel> getAllQuestions() {
		return questionRepo.findAll();
	}
	
	public void createQuestion(QuestionsModel question) {
		questionRepo.save(question);
	}
	
	public QuestionsModel findOne(Long id) {
		return questionRepo.findOne(id);
	}
}
