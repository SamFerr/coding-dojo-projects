package com.codingdojo.overflow.services;

import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.AnswersModel;
import com.codingdojo.overflow.repositories.AnswersRepository;

@Service
public class AnswersService {

	private final AnswersRepository answerRepo;
	
	public AnswersService(AnswersRepository answerRepo) {
		this.answerRepo = answerRepo;
	}
	
	public void createAnswer(AnswersModel answer) {
		answerRepo.save(answer);
		
	}

}
