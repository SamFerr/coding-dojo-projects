package com.codingdojo.overflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.overflow.models.QuestionsModel;

public interface QuestionsRepository extends CrudRepository<QuestionsModel, Long>{

	List<QuestionsModel> findAll();
	
}
