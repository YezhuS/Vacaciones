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

import com.capg.models.Project;
import com.capg.repositories.ProjectRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping("/projects")
	public List<Project> getAllProjects(){
		List<Project> projectList = new ArrayList<>();
		projectRepository.findAll().forEach(projectList::add);
		
		return projectList;
	}
	
	@GetMapping("/projects/{id}")
	public Optional<Project> getProject(@PathVariable ("id") int id){
		Optional<Project> projects = projectRepository.findById(id);
		
		return projects;
	}
	
	@PostMapping("/projects")
	public Project postProject(@RequestBody Project project) {
		Project _project = projectRepository.save(new Project(project.getId(), project.getName(), project.getDescription(), project.getStarDate(), project.getEndDate()));
		
		return _project;
	}
	
	@PutMapping("/projects/{id}")
	public ResponseEntity<Project> putProject(@PathVariable ("id") int id, @RequestBody Project project){
		Optional<Project> projectData = projectRepository.findById(id);
		
		if(projectData.isPresent()) {
			Project _project = projectData.get();
			
			_project.setId(project.getId());
			_project.setName(project.getName());
			_project.setDescription(project.getDescription());
			_project.setStarDate(project.getStarDate());
			_project.setEndDate(project.getEndDate());
			
			return new ResponseEntity<>(projectRepository.save(_project), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/projects")
	public ResponseEntity<String> deleteAllProjects(){
		projectRepository.deleteAll();
		
		return new ResponseEntity<>("Ostia puta, ¿dónde dejé el proyecto?", HttpStatus.OK);
	}
	
	@DeleteMapping("/projects/{id}")
	public ResponseEntity<String> deleteProject(@PathVariable ("id") int id){
		projectRepository.deleteById(id);
		
		return new ResponseEntity<>("The project ID: " + id + " fly away into the toilet", HttpStatus.OK);
	}
	
}
