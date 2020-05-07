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

import com.capg.models.Absence;
import com.capg.models.Skill;
import com.capg.repositories.SkillRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SkillController {

	
	@Autowired
	private SkillRepository skillRepository;
	
	@GetMapping("/skills")
	public List<Skill> getAllSkills(){
		List<Skill> skillList = new ArrayList<>();
		skillRepository.findAll().forEach(skillList::add);
		
		return skillList;
	}
	
	@GetMapping("/skills/{id}")
	public Optional<Skill> getSkill(@PathVariable("id") int id){
		Optional<Skill> skills = skillRepository.findById(id);
		
		return skills;
	}
	
	@PostMapping("skills")
	public Skill postSkill(@RequestBody Skill skill) {
		Skill _skill = skillRepository.save(new Skill(skill.getId(), skill.getName(), skill.getDescription()));
		
		return _skill;
	}
	
	@PutMapping("/skills/{id}")
	public ResponseEntity<Skill> putSkill(@PathVariable ("id") int id, @RequestBody Skill skill){
		Optional<Skill> skillData = skillRepository.findById(id);
		
		if(skillData.isPresent()) {
			Skill _skill = skillData.get();
			
			_skill.setId(skill.getId());
			_skill.setName(skill.getName());
			_skill.setDescription(skill.getDescription());
			
			return new ResponseEntity<>(skillRepository.save(_skill), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/skills")
	public ResponseEntity<String> deleteAllSkills(){
		skillRepository.deleteAll();
		
		return new ResponseEntity<>("Ai mijo mis skills se fueron a la arboleda", HttpStatus.OK);
	}
	
	@DeleteMapping("/skills/{id}")
	public ResponseEntity<String> deleteSkill(@PathVariable ("id") int id){
		skillRepository.deleteById(id);
		
		return new ResponseEntity<>("The skill ID: " + id + " se fue por la arboleda", HttpStatus.OK);
	}
}
