package com.capg.models;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) 
@Entity
@Table(name="skill")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	
	//Relación Muchos-Muchos con Modelo Project
	@ManyToMany(mappedBy = "projectsSkills")
	Set<Project> projectSkill;
	

	
	//Relación Muchos-Muchos con Modelo employee
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="skill_employee", 
			joinColumns = @JoinColumn(name = "id_employee", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "id_skill", referencedColumnName = "id"))
	Set<Employee> ListSkill;
	
	//Constructor
	
	public Skill() {
		
	}
	
	public Skill(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}


	
	//Getters & Setters
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	//Getters & Setters Sets
	
	public Set<Project> getProjectSkill() {
		return projectSkill;
	}

	public void setProjectSkill(Set<Project> projectSkill) {
		this.projectSkill = projectSkill;
	}
//		
//	public Set<Employee> getEmployeeSkill() {
//		return employeeSkill;
//	}
//
//	public void setEmployeeSkill(Set<Employee> employeeSkill) {
//		this.employeeSkill = employeeSkill;
//	}



	@Override
	  public String toString() {
	    return "Customer [id=" + id + ", name = " + name + ", description = " + description + "]";
	  }


}
