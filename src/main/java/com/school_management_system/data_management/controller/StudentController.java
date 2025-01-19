package com.school_management_system.data_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.school_management_system.data_management.models.Credential;
import com.school_management_system.data_management.models.User;
import com.school_management_system.data_management.service.CredentialService;
import com.school_management_system.data_management.service.UserService;


@RestController
@RequestMapping("/student")
public class StudentController {

    
    @Autowired
    private CredentialService credentialService;

    @Autowired
    private UserService userService;
   
   

    // Endpoint to enroll a student in a subject
    @PostMapping("/enroll")
    public void enrollInSubject() { 
        System.out.println("Student ID: ");

        System.out.println("Student ID: ");
        Credential credential = new Credential();
        credential.setName("John Doe");
        credential.setUsername("johndoe");
        credential.setPassword("password");
        credential.setRole("principal");
        credentialService.saveCredential(credential);

        Credential credential2 = credentialService.getCredentialByUsername("johndoe");
        System.out.println(credential2.getName());
    }

    @GetMapping("/details")
    public User studentDetails(@RequestParam String studentName) { 
        System.out.println("student detail fetching ...");
        User user = userService.getUserByName(studentName);
        System.out.println("student detail fetched");
        return user;
    }

    
    
}