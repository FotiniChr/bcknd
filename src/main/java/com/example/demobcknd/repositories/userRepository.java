package com.example.demobcknd.repositories;

import com.example.demobcknd.models.User;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called Repo
// CRUD refers Create, Read, Update, Delete

public interface userRepository extends CrudRepository<User, Integer> {

}
