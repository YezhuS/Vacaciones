package com.capg.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) 
@Entity
@Table(name="project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="starDate")
	private LocalDate starDate;
	
	@Column(name="endDate")
	private LocalDate endDate;
	
	
	//Relación 1-Muchos con Modelo EmployeeProjectPeriod
	@OneToMany(mappedBy = "project")
	List<EmployeeProjectPeriod> projectsPeriods;
	
	//Relación Muchos-Muchos con Modelo Employee
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="employee_project", 
			joinColumns = @JoinColumn(name = "id_project", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "id_employee", referencedColumnName = "id"))
	Set<Employee> ListProjects;
	
	//Relación Muchos-Muchos con Modelo Skill
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="project_skill", 
			joinColumns = @JoinColumn(name = "id_project", referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "id_skill", referencedColumnName = "id"))
	Set<Employee> projectsSkills;	
	
	
	//Constructors
	
	public Project() {
		
	}
	
	public Project(int id, String name, String description, LocalDate starDate, LocalDate endDate) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.starDate = starDate;
		this.endDate = endDate;
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

	public LocalDate getStarDate() {
		return starDate;
	}

	public void setStarDate(LocalDate starDate) {
		this.starDate = starDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	//Getters & Setters Sets, Lists
//	
//	public Set<Employee> getEmployeesProjects() {
//		return employeesProjects;
//	}
//
//	public void setEmployeesProjects(Set<Employee> employeesProjects) {
//		this.employeesProjects = employeesProjects;
//	}
	
//	public Set<Employee> getProjectsSkills() {
//		return projectsSkills;
//	}
//
//	public void setProjectsSkills(Set<Employee> projectsSkills) {
//		this.projectsSkills = projectsSkills;
//	}

//	public List<EmployeeProjectPeriod> getProjectsPeriods() {
//		return projectsPeriods;
//	}
//
//	public void setProjectsPeriods(List<EmployeeProjectPeriod> projectsPeriods) {
//		this.projectsPeriods = projectsPeriods;
//	}
	
	



	@Override
	  public String toString() {
	    return "Customer [id=" + id + ", name = " + name + ", starDate=" + starDate +  ", endDate=" + endDate + ", description = " + description + "]";
	  }


	
}