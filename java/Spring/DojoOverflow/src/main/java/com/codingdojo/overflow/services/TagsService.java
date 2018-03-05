package com.codingdojo.overflow.services;

import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.TagsModel;
import com.codingdojo.overflow.repositories.TagsRepository;

@Service
public class TagsService {
	
	private final TagsRepository tagRepo;

	public TagsService(TagsRepository tagRepo) {
		this.tagRepo = tagRepo;
	}
	
	public TagsModel findOrCreateTag(String subject) {
		TagsModel tagByName = tagRepo.findBySubject(subject);
		if(tagByName == null) {
			TagsModel tag = new TagsModel();
			tag.setSubject(subject);
			return tagRepo.save(tag);
		}
		else {
			return tagByName;
		}
	}

}
