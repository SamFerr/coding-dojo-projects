package com.codingdojo.pagination.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.codingdojo.pagination.models.Dojo;

public interface DojoRepository extends PagingAndSortingRepository<Dojo, Long>{
	@Query("SELECT d, n FROM Dojo d JOIN d.ninjas n")
	Page<Object[]> joinDojosAndNinjas(Pageable p);
}