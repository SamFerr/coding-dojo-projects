package com.codingdojo.dojo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojo.models.NinjaModel;

@Repository
public interface NinjaRepository extends PagingAndSortingRepository<NinjaModel, Long>{

}
