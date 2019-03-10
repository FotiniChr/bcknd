package com.example.demobcknd.service;

import org.springframework.stereotype.Service;

import java.util.Hashtable;

import com.example.demobcknd.model.person;

@Service
public class PersonService{

     Hashtable<String, person> persons = new Hashtable<String, person>(); 

    public PersonService(){
        person p = new person();
        p.setId("1");
        p.setFirst_name("notos");
        p.setAge(5);
        persons.put("1", p);

        person t = new person();
        t.setId("2");
        t.setFirst_name("leas");
        t.setAge(15);
        persons.put("2", t);
    }

    public person getPerson(String id){
        if(persons.containsKey(id))
            return persons.get(id);
        else
            return null;
    }

    public Hashtable<String, person> getAll(){
        return persons;
    }

    
}