package com.codingdojo.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.languages.models.LanguageModel;

@Repository
public interface LanguageRepository extends CrudRepository<LanguageModel, Long>{
	List<LanguageModel> findAll();
}
