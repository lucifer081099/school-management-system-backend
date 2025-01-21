package com.school_management_system.data_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.school_management_system.data_management.dto.EnrollmentRequest;
import com.school_management_system.data_management.models.Credential;
import com.school_management_system.data_management.models.User;
import com.school_management_system.data_management.service.CredentialService;
import com.school_management_system.data_management.service.UserService;


@RestController
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private UserService userService;
   
   

    // Endpoint to enroll a student in a subject
    @PostMapping("/enroll")
    public void enrollInSubject(@RequestParam String subjectName, @RequestParam String studentName) {
        System.out.println("Subject Name: " + subjectName);
        User user = userService.getUserByName(studentName);
        System.out.println("user: " + user.toString());
        if(user!=null){
            if(subjectName.equals("Mathematics")){
                System.out.println("Enrolling student in Mathematics");
                user.setMathematics("0");
            }else if(subjectName.equals("Science")){
                System.out.println("Enrolling student in Science");
                user.setScience("0");

            }else if(subjectName.equals("English")){
                System.out.println("Enrolling student in English");
                user.setEnglish("0");

            }else if(subjectName.equals("History")){
                System.out.println("Enrolling student in History");

                user.setHistory("0");
            }else if(subjectName.equals("Hindi")){
                System.out.println("Enrolling student in Hindi");
                user.setHindi("0");
            }else if(subjectName.equals("Economics")){   
                System.out.println("Enrolling student in Economics"); 
                user.setEconomics("0");
            }
            System.out.println("user"+user.toString());
        
            userService.saveUser(user);
        }
    }


    @GetMapping("/details")
    public User studentDetails(@RequestParam String studentName) { 
        System.out.println("student detail fetching ...");
        User user = userService.getUserByName(studentName);
        System.out.println("student detail fetched");
        return user;
    }

    
    
}