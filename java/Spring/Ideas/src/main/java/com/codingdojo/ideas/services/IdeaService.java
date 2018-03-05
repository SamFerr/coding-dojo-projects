package com.codingdojo.ideas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.ideas.models.Idea;
import com.codingdojo.ideas.models.User;
import com.codingdojo.ideas.repositories.IdeaRepository;
import com.codingdojo.ideas.repositories.UserRepository;

@Service
public class IdeaService {
	private final IdeaRepository ideaRepo;
	private final UserRepository userRepo;
	
	public IdeaService(IdeaRepository ideaRepo, UserRepository userRepo) {
		this.ideaRepo = ideaRepo;
		this.userRepo = userRepo;
	}
	
	public void createIdea(Idea idea) {
		ideaRepo.save(idea);
	}
	
	public void deleteIdea(Long id) {
		Idea idea = ideaRepo.findOne(id);
		ideaRepo.delete(idea);
	}

	public Idea findById(Long id) {
		return ideaRepo.findById(id);
	}

	public List<Idea> findAllIdeas() {
		return ideaRepo.findAll();
	}

	public void likeIdea(Long ideaId, Long userId) {
		Idea idea = ideaRepo.findOne(ideaId);
		User user = userRepo.findOne(userId);
		idea.getLikers().add(user);
		ideaRepo.save(idea);
	}
	

	
//	Idea idea = ideaRepo.findOne(ideaId);
//	User user = userRepo.findOne(userId);
//	List<User> likers = idea.getLikers();
//	likers.add(user);
//	ideaRepo.save(idea);

}
