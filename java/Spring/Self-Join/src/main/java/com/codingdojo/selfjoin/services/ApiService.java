package com.codingdojo.selfjoin.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.selfjoin.models.Employee;
import com.codingdojo.selfjoin.repositories.EmployeeRepo;

@Service
public class ApiService {
	private final EmployeeRepo employeeRepo;
	
	public ApiService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public void createEmployees() {
		Employee[] employeez = {
				new Employee("John", "Doe"),
				new Employee("Jane", "Doe"),
				new Employee("Michael", "Johnson"),
				new Employee("Michelle", "Johnson"),
				new Employee("Kevin", "Smith"),
				new Employee("Karren", "Smith"),
		};
		
		for(Employee emoney : employeez) {
			employeeRepo.save(emoney);
		}
	}
	
	public void createManagers() {
		Employee managa = employeeRepo.findOne((long) 1);
		for(long i = 2; i < 7; i++) {
			Employee emoney2 = employeeRepo.findOne(i);
			emoney2.setManager(managa);
			employeeRepo.save(emoney2);
		}
	}	
	
	public List<Employee> findEmployees(Long managerId) {
		return employeeRepo.findOne(managerId).getEmployees();
	}
	
	public Employee findManager(Long employeeId) {
		return employeeRepo.findOne(employeeId).getManager();
	}	
}