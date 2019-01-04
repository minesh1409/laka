package com.lakazambia.selfcare.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lakazambia.selfcare.model.User;
import com.lakazambia.selfcare.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

   

    public void save(User user){
    	System.out.println("First Name :: " +user.getFirstName());
    	System.out.println("Last Name :: " +user.getLastName());
    	System.out.println("User Name :: " +user.getUsername());
    	System.out.println("Password :: " +user.getPassword());
    	System.out.println("Email :: " +user.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User getUser(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
