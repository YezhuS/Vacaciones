package com.capg.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) 
@Entity
@Table(name="employee_project_period")
public class EmployeeProjectPeriod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="id_employee")
	private int idEmployee;
	
	@Column(name="id_project")
	private int idProject;
		
	@Column(name="star_date")
	private LocalDate starDate;
	
	@Column(name="end_date")
	private LocalDate endDate;
	
	@Column(name="dedication")
	private int dedication;
	
	
	
	// Relación Muchos-1 con Modelo Employee
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_employee", referencedColumnName = "id", insertable = false, updatable = false)
	Employee employees;
	
	// Relación Muchos-1 con Modelo Project
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project", referencedColumnName = "id", insertable = false, updatable = false)
	Project project;
	
	
	
	
	//Constructor
	
	public EmployeeProjectPeriod () {
		
	}
	
	public EmployeeProjectPeriod (int id, int idEmployee, int idProject, LocalDate starDate, LocalDate endDate, int dedication) {
		this.id = id;
		this.idEmployee = idEmployee;
		this.idProject = idProject;
		this.starDate = starDate;
		this.endDate = endDate;
		this.dedication = dedication;
	}

	
	//Getters & Setters

	public int getIdEmployee() {
		return idEmployee;
	}


	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}


	public int getIdProject() {
		return idProject;
	}


	public void setIdProject(int idProject) {
		this.idProject = idProject;
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


	public int getDedication() {
		return dedication;
	}


	public void setDedication(int dedication) {
		this.dedication = dedication;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	  public String toString() {
	    return "Customer [id=" + id + ", idEmployee=" + idEmployee + ", idProject=" + idProject + ", starDate=" + starDate +  ", endDate=" + endDate + ", dedication = " + dedication + "]";
	  }
}