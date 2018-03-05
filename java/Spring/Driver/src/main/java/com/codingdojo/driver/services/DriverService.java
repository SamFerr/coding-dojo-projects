package com.codingdojo.driver.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.driver.models.License;
import com.codingdojo.driver.models.Person;
import com.codingdojo.driver.repositories.LicenseRepository;
import com.codingdojo.driver.repositories.PersonRepository;

@Service
public class DriverService {
	
	private final LicenseRepository licenseRepo;
	private final PersonRepository personRepo;
	
	public DriverService(LicenseRepository licenseRepo, PersonRepository personRepo) {
		this.licenseRepo = licenseRepo;
		this.personRepo = personRepo;
	}

	public List<Person> allPersons() {
		return personRepo.findAll();
	}
	
	public void addPerson(Person person) {
		personRepo.save(person);
	}
	
	public Person getPerson(Long id) {
		return personRepo.findOne(id);
	}
	
	public License addLicense(License license) {
		Long personId = license.getPerson().getId();
		// Pad with 0 with a width of 6
		String licNumber = String.format("%06d", personId);

		license.setNumber(licNumber);
		License lic = licenseRepo.save(license);
		
		return lic;
	}


}
