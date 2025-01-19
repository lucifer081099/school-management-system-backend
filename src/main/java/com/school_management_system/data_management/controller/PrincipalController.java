package com.school_management_system.data_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.school_management_system.data_management.dto.AuthRequest;
import com.school_management_system.data_management.dto.AuthResponse;
import com.school_management_system.data_management.models.Credential;
import com.school_management_system.data_management.service.CredentialService;
import com.school_management_system.data_management.service.UserService;


@RestController
@RequestMapping("/principal")
public class PrincipalController {

    
    @Autowired
    private CredentialService credentialService;

    @Autowired
    private UserService userService;
   

    // Endpoint to enroll a student in a subject
    @RequestMapping("/enroll")
    public void enrollInSubject() { 
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

    @PostMapping("/update-score")

    public void updateScore(@RequestParam Integer score,@RequestParam String studentName, 
                                   @RequestParam String subjectName) throws Exception {

        System.out.println("inside update score"+studentName+subjectName+score);
        userService.updateScore(studentName, subjectName, score);
    }
    
}