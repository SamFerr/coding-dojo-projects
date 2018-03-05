package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codingdojo.countries.models.Country;

public interface CountryRepo extends CrudRepository<Country, Long>{
	@Query("SELECT cuntry.name, lame.language, lame.percentage FROM Country cuntry JOIN cuntry.languages lame WHERE language = ?1 ORDER BY percentage DESC")
	List<Object[]> findCountriesByLanguageDesc(String language);
	
	@Query("SELECT cuntry.name, COUNT(cuntry.id) AS numberOfCities FROM Country cuntry JOIN cuntry.cities cty GROUP BY cuntry.id ORDER BY numberOfCities DESC")
	List<Object[]> findCountriesWithNumCities();
	
	@Query("SELECT cuntry.name, lame.language, lame.percentage FROM Country cuntry JOIN cuntry.languages lame WHERE lame.percentage >= ?1 ORDER BY lame.percentage DESC")
	List<Object[]> findLanguagesWithPercentageGreaterThan(Double percentage);
	
	@Query("SELECT cuntry FROM Country cuntry WHERE cuntry.surfaceArea < ?1 AND cuntry.population > ?2")
	List<Country> findCountriesWithSurfaceAreaBelowThanAndPopulationGreaterThan(Double surfaceArea, Integer population);
	
	@Query("SELECT cuntry FROM Country cuntry WHERE cuntry.governmentForm = ?1 AND cuntry.capital > ?2 AND cuntry.lifeExpectancy > ?3")
	List<Country> findCountriesWithGovermentFormAndCapitalGreaterThanAndLifeExpectancyGreaterThan(String govermentForm, Integer capital, Double lifeExpectancy);
	
	@Query("SELECT cuntry.name, cty.name, cty.district, cty.population FROM Country cuntry JOIN cuntry.cities cty WHERE cuntry.name = 'Argentina' AND cty.district = 'Buenos Aires' AND cty.population > ?1")
	List<Object[]> findCitiesInArgentinaInBuenosAiresWithPopulationGreaterThan(Integer population);
	
	@Query("SELECT cuntry.region, COUNT(cuntry.id) AS numberOfCountries FROM Country cuntry GROUP BY cuntry.region ORDER BY numberOfCountries DESC")
	List<Object[]> findNumberOfCountriesInEachRegion();
}