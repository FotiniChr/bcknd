package com.example.demobcknd.Repositories;

import com.example.demobcknd.model.User;

import org.springframework.data.repository.CrudRepository;



// This will be AUTO IMPLEMENTED by Spring into a Bean called Repo
// CRUD refers Create, Read, Update, Delete




public interface Repo extends CrudRepository<User, Integer> {

}
