// package com.example.service;

// import org.springframework.stereotype.Service;

// import java.util.Hashtable;

// import com.example.model.*;

// @Service
// public class PersonService{

//     Hashtable<String, person> persons = new Hashtable<String, person>(); 

//     public PersonService(){
//         person p = new person();
//         p.setId("1");
//         p.setFirst_name("notos");
//         p.setAge(5);
//         persons.put("1", p);

//         p = new person();
//         p.setId("2");
//         p.setFirst_name("leas");
//         p.setAge(15);
//         persons.put("2", p)
//     }

//     public person getPerson(String id){
//         if(persons.containsKey(id))
//             return persons.get(id);
//         else
//             return null;
//     }

//     public Hashtable<String, person> getAll(){
//         return persons;
//     }

    
// }