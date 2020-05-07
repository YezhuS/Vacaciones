package com.capg.repositories;


import org.springframework.data.repository.CrudRepository;

import com.capg.models.Customer;
 

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}