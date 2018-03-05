package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.countries.models.City;

public interface CityRepo extends CrudRepository<City, Long>{
	@Query("SELECT cty FROM City cty JOIN cty.country cuntry WHERE cuntry.name = ?1 AND cty.population >= ?2 ORDER BY cty.population DESC")
	List<City> findCitiesInCountryWithPopulationGreaterThan(String country, Integer population);
}