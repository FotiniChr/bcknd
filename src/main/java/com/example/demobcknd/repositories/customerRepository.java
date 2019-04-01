package com.example.demobcknd.repositories;


import com.example.demobcknd.models.customer;

import org.springframework.data.repository.CrudRepository;



public interface customerRepository extends CrudRepository<customer, Long> {
}
