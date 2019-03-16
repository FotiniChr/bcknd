package com.example.demobcknd.services;

import com.example.demobcknd.Repositories.Repo;
import com.example.demobcknd.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired // This means to get the bean called userRepository
               // Which is auto-generated by Spring, we will use it to handle the data
    private Repo userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();

    }

    public User findUser(int id) {
        return userRepository.findById(id).get();
    }

    public String addUser(String name, String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "deleted";
    }

    public String updateUser(int id, String email, String name) {
        User n = userRepository.findById(id).get();
        n.setEmail(email);
        n.setName(name);
        userRepository.save(n);
        return "updated";
    }

}