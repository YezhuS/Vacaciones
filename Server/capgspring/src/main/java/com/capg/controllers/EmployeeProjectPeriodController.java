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

import com.capg.models.EmployeeProjectPeriod;
import com.capg.repositories.EmployeeProjectPeriodRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeProjectPeriodController {

	
	@Autowired
	private EmployeeProjectPeriodRepository employeeProjectPeriodRepository;
	
	@GetMapping("/projectsPeriod")
	public List<EmployeeProjectPeriod> getAllProjects(){
		List<EmployeeProjectPeriod> projectList = new ArrayList<>();
		employeeProjectPeriodRepository.findAll().forEach(projectList::add);
		
		return projectList;
	}
	
	@GetMapping("/projectsPeriod/{id}")
	public Optional<EmployeeProjectPeriod> getProject(@PathVariable ("id") int id){
		Optional<EmployeeProjectPeriod> projects = employeeProjectPeriodRepository.findById(id);
		
		return projects;
	}
	
	@PostMapping("/projectsPeriod")
	public EmployeeProjectPeriod postProject(@RequestBody EmployeeProjectPeriod project) {
		EmployeeProjectPeriod _project = employeeProjectPeriodRepository.save(new EmployeeProjectPeriod(project.getId(), project.getIdEmployee(), project.getIdProject(), project.getEndDate(), project.getStarDate(), project.getDedication()));
		
		return _project;
	}
	
	@PutMapping("/projectsPeriod/{id}")
	public ResponseEntity<EmployeeProjectPeriod> putProject(@PathVariable ("id") int id, @RequestBody EmployeeProjectPeriod project){
		Optional<EmployeeProjectPeriod> projectData = employeeProjectPeriodRepository.findById(id);
		
		if(projectData.isPresent()) {
			EmployeeProjectPeriod _project = projectData.get();
			
			_project.setId(project.getId());
			_project.setIdEmployee(project.getIdEmployee());
			_project.setIdProject(project.getIdProject());
			_project.setStarDate(project.getStarDate());
			_project.setEndDate(project.getEndDate());
			_project.setDedication(project.getDedication());
			
			return new ResponseEntity<>(employeeProjectPeriodRepository.save(_project), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/projectsPeriod")
	public ResponseEntity<String> deleteAllProjects(){
		employeeProjectPeriodRepository.deleteAll();
		
		return new ResponseEntity<>("Ostia puta, ¿dónde dejé el proyecto?", HttpStatus.OK);
	}
	
	@DeleteMapping("/projectsPeriod/{id}")
	public ResponseEntity<String> deleteProject(@PathVariable ("id") int id){
		employeeProjectPeriodRepository.deleteById(id);
		
		return new ResponseEntity<>("The projectPeriod ID: " + id + " fly away into the toilet", HttpStatus.OK);
	}
	
	
}
