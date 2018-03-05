package com.codingdojo.ideas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ideas.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {
	
	@Query("SELECT i from Idea i ORDER BY i.likers.size DESC")
	List<Idea> findAll();

	Idea findById(Long id);

}
