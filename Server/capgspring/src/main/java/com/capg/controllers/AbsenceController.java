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
import com.capg.repositories.AbsenceRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AbsenceController {

	
	@Autowired
	private AbsenceRepository absenceRepository;
	
	@GetMapping("/absences")
	public List<Absence> getAllAbsences(){
		List<Absence> absenceList = new ArrayList<>();
		absenceRepository.findAll().forEach(absenceList::add);
		
		return absenceList;
	}
	
	@GetMapping("/absences/{id}")
	public Optional<Absence> getAbsence(@PathVariable ("id") int id){
		Optional<Absence> absences = absenceRepository.findById(id);
		
		return absences;
	}
	
	
	@PostMapping("/absences")
	public Absence postAbsence(@RequestBody Absence absence) {
		Absence _absence = absenceRepository.save(new Absence(absence.getId(), absence.getType(), absence.getDescription(), absence.getStarDate(), absence.getEndDate()));
		
		return _absence;
	}
	
	@PutMapping("/absences/{id}")
	public ResponseEntity<Absence> putAbsence(@PathVariable ("id") int id, @RequestBody Absence absence){
		Optional<Absence> absenceData = absenceRepository.findById(id);
		
		if(absenceData.isPresent()) {
			Absence _absence = absenceData.get();
			
			_absence.setId(absence.getId());
			_absence.setType(absence.getType());
			_absence.setDescription(absence.getDescription());
			_absence.setStarDate(absence.getStarDate());
			_absence.setEndDate(absence.getEndDate());
			
			return new ResponseEntity<>(absenceRepository.save(_absence), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/absences")
	public ResponseEntity<String> deleteAllAbsences(){
		absenceRepository.deleteAll();
		
		return new ResponseEntity<>("¡Adiós a las ausencias!", HttpStatus.OK);
	}
	
	@DeleteMapping("/absences/{id}")
	public ResponseEntity<String> deleteAbsence(@PathVariable ("id") int id){
		absenceRepository.deleteById(id);
		
		return new ResponseEntity<>("The absence ID: " + id + " se queda sin ausencia.", HttpStatus.OK);
	}
}
