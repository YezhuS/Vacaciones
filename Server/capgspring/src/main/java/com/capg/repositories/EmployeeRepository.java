package com.capg.repositories;


import org.springframework.data.repository.CrudRepository;

import com.capg.models.Employee;
 

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}