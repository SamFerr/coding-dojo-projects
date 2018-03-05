package com.codingdojo.selfjoin.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.selfjoin.models.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long>{

}