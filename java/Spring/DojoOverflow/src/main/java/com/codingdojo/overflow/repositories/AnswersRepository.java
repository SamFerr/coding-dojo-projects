package com.codingdojo.overflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.overflow.models.AnswersModel;

@Repository
public interface AnswersRepository extends CrudRepository<AnswersModel, Long>{
}
