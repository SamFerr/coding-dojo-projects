package com.codingdojo.dojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojo.models.DojoModel;
import com.codingdojo.dojo.models.NinjaModel;
import com.codingdojo.dojo.repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}

	public List<DojoModel> getAll() {
		return dojoRepository.findAll();
	}

	public DojoModel getDojo(Long id) {
		return dojoRepository.findOne(id);
	}

	public void createDojo(DojoModel dojo) {
		dojoRepository.save(dojo);
	}
	
	List<Object[]> dojos = dojoRepository.findAllDojosNamesWithId2();
	Object[] dojo = dojos.get(0);
	Object dojoId = dojo[0];
	Object dojoName = dojo[1];
	
	
	List<Object[]> table = dojoRepository.joinDojosAndNinjas2();
	for(Object[] row : table) {
	    DojoModel dojo = (DojoModel) row[0];
	    NinjaModel ninja = (NinjaModel) row[1];
	    System.out.println(dojo.getName());
	    System.out.println(ninja.getFirstName());
	}

}
