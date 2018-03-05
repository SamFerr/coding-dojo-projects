package com.codingdojo.pagination.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.pagination.repositories.DojoRepository;

@Service
public class ApiService {
	private final DojoRepository dojoRepository;
	
	public ApiService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public Page<Object[]> joinDojosAndNinjas(int pageNumber) {
		PageRequest pageRequest = new PageRequest(pageNumber, 5, Sort.Direction.ASC, "name");
		Page<Object[]> dojos = dojoRepository.joinDojosAndNinjas(pageRequest);

		return dojos;
	}
}