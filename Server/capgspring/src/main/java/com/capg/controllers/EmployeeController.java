package com.capg.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.models.Employee;
import com.capg.repositories.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		List<Employee> employeesList = new ArrayList<>();
		employeeRepository.findAll().forEach(employeesList::add);
		
		return employeesList;
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> findById(@PathVariable ("id") int id ){
		Optional<Employee> employees = employeeRepository.findById(id);
		return employees;
	}
	
	@PostMapping("/employees")
	public Employee postEmployees(@RequestBody Employee employee) {
		
		Employee _employee = employeeRepository.save(new Employee(employee.getId(), employee.getHireDate()));
		return _employee;
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> putEmployees(@PathVariable("id") int id, @RequestBody Employee employee){
	    
		System.out.println("Update Employee with ID = " + id + "...");
	    
	    Optional<Employee> employeeData = employeeRepository.findById(id);
	    
	    
	    if(employeeData.isPresent()) {
	    	Employee _employee = employeeData.get();
	    	
	    	_employee.setId(employee.getId());
	    	_employee.setHireDate(employee.getHireDate());
	    	
	    	return new ResponseEntity<>(employeeRepository.save(_employee), HttpStatus.OK);
	    }else {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<String> deleteAllEmployees(){
		System.out.println("Killing them all 3, 2, 1 ....");
		
		employeeRepository.deleteAll();
		
		return new ResponseEntity<>("They've gone to la puta", HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable ("id") int id){
		System.out.println("Killing er ID: " + id + "en 3, 2, 1 ....");
		
		employeeRepository.deleteById(id);
		
		return new ResponseEntity<>("The employee ID: " + id + " went to la puta", HttpStatus.OK);
	}
}
