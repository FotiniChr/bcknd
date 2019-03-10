// package com.example.controller;

// import java.util.Hashtable;

// import com.example.model.person;
// import com.example.service.PersonService;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/persons")
// public class PersonController{

//     @Autowired
//     PersonService ps;

//     @RequestMapping("/all")
//     public Hashtable<String, person> getAll(){
//         return ps.getAll();
//     }

//     @RequestMapping("{id}")
//     public person getPerson(@PathVariable("id") String id){
//         return ps.getPerson(id);
//     }

// }

