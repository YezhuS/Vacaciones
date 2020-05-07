package com.capg.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) 
@Entity
@Table(name = "customer")
public class Customer {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
 
  @Column(name = "name")
  private String name;
  
  @Column(name="lastname")
  private String lastName;
 
  @Column(name = "age")
  private int age;
 
  @Column(name = "active")
  private boolean active;
  
  @Column(name="email")
  private String email;
  
  @Column(name="password")
  private String password;
  
  @Column(name="rol")
  private String rol;
  
  @Column(name="language")
  private String language;
  
  
  //Relación 1-1 con Modelo Employee
  @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
  Employee employee;
  
  
  
  //Constructors
  
  public Customer() {
  }
 
  public Customer(String name, String lastName, int age, String email, String password, String rol, String language) {
    this.name = name;
    this.age = age;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.rol = rol;
    this.language = language;
    this.active = false;
  }
  
  
  
  //Getters & Setters
 
  public int getId() {
    return id;
  }
 
  public void setName(String name) {
    this.name = name;
  }
 
  public String getName() {
    return this.name;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
	 
  public String getLastName() {
    return this.lastName;
  }
 
  public void setAge(int age) {
    this.age = age;
  }
 
  public int getAge() {
    return this.age;
  }
 
  public boolean isActive() {
    return active;
  }
 
  public void setActive(boolean active) {
    this.active = active;
  }
 
  public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRol() {
	return rol;
}

public void setRol(String rol) {
	this.rol = rol;
}

public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}



//public Employee getEmployee() {
//	return employee;
//}
//
//public void setEmployee(Employee employee) {
//	this.employee = employee;
//}

public void setId(int id) {
	this.id = id;
}

@Override
  public String toString() {
    return "Customer [id=" + id + ", name=" + name + ", lastName=" + lastName +  ", age=" + age + ", email=" + email + ", password=" + password + ", rol=" + rol + ", language" + language + ", active=" + active + "]";
  }
}