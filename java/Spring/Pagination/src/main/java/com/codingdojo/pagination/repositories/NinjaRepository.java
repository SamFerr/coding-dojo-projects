package com.codingdojo.pagination.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.codingdojo.pagination.models.Ninja;

public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long>{

}