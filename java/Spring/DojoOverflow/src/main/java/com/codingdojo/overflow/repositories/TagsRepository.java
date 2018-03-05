package com.codingdojo.overflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.overflow.models.TagsModel;

public interface TagsRepository extends CrudRepository<TagsModel, Long>{
	TagsModel findBySubject(String subject);
}
