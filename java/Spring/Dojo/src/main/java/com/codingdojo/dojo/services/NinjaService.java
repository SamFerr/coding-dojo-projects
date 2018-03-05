package com.codingdojo.dojo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.dojo.models.NinjaModel;
import com.codingdojo.dojo.repositories.NinjaRepository;

@Service
@Transactional
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

	public NinjaModel createNinja(NinjaModel ninja) {
		return ninjaRepository.save(ninja);
	}
	
	@Autowired 
    NinjaRepository ninjaRepo;
    // static variable to set the number of ninjas that we want per page
    private static final int PAGE_SIZE = 5;
    public Page<NinjaModel> ninjasPerPage(int pageNumber) {
        // get all the ninjas page and sort them in ascending order the last name property
        PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "lastName");
        Page<NinjaModel> ninjas = ninjaRepo.findAll(pageRequest);
        return ninjaRepo.findAll(pageRequest);
    }

}
