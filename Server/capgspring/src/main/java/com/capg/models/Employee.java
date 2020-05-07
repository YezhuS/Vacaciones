package com.capg.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) 
@Entity
@Table(name="employee")
public class Employee{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="hiredate")
	private LocalDate hireDate;
	
	
	//Relación 1-1 con Modelo Customer
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@MapsId("id")
	@JoinColumn(name = "id", nullable = false)
	Customer customer;
	
	//Relación 1-Muchos con Modelo EmployeeProjectPeriod
	@OneToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	List<EmployeeProjectPeriod> employeeProjects;
	
	//Relación 1-Muchos con Modelo Absence
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	List<Absence> employeeAbsences;
	
	//Relación Muchos-Muchos con Modelo Project
	@ManyToMany(mappedBy="ListProjects")
	Set<Project> ListProject;
	
	//Relación Muchos-Muchos con Modelo Skill
	@ManyToMany(mappedBy = "ListSkill")
	Set<Skill> ListSkills;
	
	
	
	//Constructors
	
	public Employee() {
		
	}
	
	public Employee(int id, LocalDate hireDate) {
		this.id = id;
		this.hireDate = hireDate;
	}
	
	
	
	//Getters & Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
	//Gettes & Setters Lists, Sets
	
//	public List<EmployeeProjectPeriod> getEmployeeProjects() {
//		return employeeProjects;
//	}
//
//	public void setEmployeeProjects(List<EmployeeProjectPeriod> employeeProjects) {
//		this.employeeProjects = employeeProjects;
//	}
	
//	public List<Absence> getEmployeeAbsences() {
//		return employeeAbsences;
//	}
//
//	public void setEmployeeAbsences(List<Absence> employeeAbsences) {
//		this.employeeAbsences = employeeAbsences;
//	}
	
	public Set<Project> getListProject() {
		return ListProject;
	}

	public void setListProject(Set<Project> listProject) {
		this.ListProject = listProject;
	}

	public Set<Skill> getListSkills() {
		return ListSkills;
	}

	public void setListSkills(Set<Skill> listSkills) {
		ListSkills = listSkills;
	}

	@Override
	  public String toString() {
	    return "Customer [id=" + id + ", HireDate = " + hireDate + "]";
	  }
	
	
}