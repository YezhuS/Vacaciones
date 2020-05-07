package com.capg.repositories;


import org.springframework.data.repository.CrudRepository;

import com.capg.models.Project;
 

public interface ProjectRepository extends CrudRepository<Project, Integer> {

}