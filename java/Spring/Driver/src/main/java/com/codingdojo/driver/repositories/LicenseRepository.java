package com.codingdojo.driver.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.driver.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

}
