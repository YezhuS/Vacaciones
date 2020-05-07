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

@Entity
@Table(name="absence")
public class Absence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="description")
	private String description;
	
	@Column(name="starDate")
	private LocalDate starDate;
	
	@Column(name="endDate")
	private LocalDate endDate;
	
	
	//Relación Muchos-1 con Modelo Employee
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	Employee employee;
	
	
	
	//Constructors
	
	public Absence() {
		
	}
	
	public Absence(int id, String type, String description, LocalDate starDate, LocalDate endDate) {
		this.id = id;
		this.type = type;
		this.description = description;
		this.starDate = starDate;
		this.endDate = endDate;
	}
	
	
	
	//Getters & Setters

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	

	
	
	@Override
	  public String toString() {
	    return "Customer [id=" + id + ", type=" + type + ", starDate=" + starDate +  ", endDate=" + endDate + ", description = " + description + "]";
	  }
}
	
	