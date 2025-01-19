package com.school_management_system.data_management.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.school_management_system.data_management.dto.AuthRequest;
import com.school_management_system.data_management.dto.AuthResponse;
import com.school_management_system.data_management.models.Credential;
import com.school_management_system.data_management.service.CredentialService;
import com.school_management_system.data_management.service.UserService;
import com.school_management_system.data_management.models.User;
import com.school_management_system.data_management.models.User.Seat;


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

    @RequestMapping("/enrollstudents")
    public void enrollInStudents() {
        Random random = new Random();
        String[] houses = {"Red", "Blue", "Green", "Yellow"};
        String[] classes = {"1A", "1B", "2A", "2B", "3A", "3B"};
        
        try {
            for(int i = 0; i < 100; i++) {
                User user = new User();
                user.setName("Student" + i);
                user.setUsername("student" + i);
                user.setRollNumber(String.format("%03d", i + 1));
                user.setUserClass(classes[random.nextInt(classes.length)]);
                user.setHouse(houses[random.nextInt(houses.length)]);
                
                List<Seat> seats = new ArrayList<>();
                user.setSeatAllocated(seats);
                
                Map<String, String> marks = new HashMap<>();
                marks.put("Mathematics", String.valueOf(60 + random.nextInt(41)));
                marks.put("Science", String.valueOf(60 + random.nextInt(41)));
                marks.put("English", String.valueOf(60 + random.nextInt(41)));
                user.setMarks(marks);
                
                userService.saveUser(user);
            }
            
        } catch (Exception e) {
                System.out.println("Error enrolling students: " + e.getMessage());
        }
    }

    @PostMapping("/update-score")
    public void updateScore(@RequestParam Integer score,@RequestParam String studentName, 
                                   @RequestParam String subjectName) throws Exception {

        System.out.println("inside update score"+studentName+subjectName+score);
        userService.updateScore(studentName, subjectName, score);
    }

    @GetMapping("/get-student-scores")
    public List<User> getScores() throws Exception {
        try {
            System.out.println("Starting to fetch scores...");
            List<User> usersRed = userService.getUserByHouse("Red");
            List<User> usersBlue = userService.getUserByHouse("Blue");
            List<User> usersGreen = userService.getUserByHouse("Green");
            List<User> usersYellow = userService.getUserByHouse("Yellow");
            List<User> users = new ArrayList<>();
            users.addAll(usersRed);
            users.addAll(usersBlue);
            users.addAll(usersGreen);
            users.addAll(usersYellow);


            System.out.println("Found " + users.size() + " students");
            return users;
        } catch (Exception e) {
            System.err.println("Error fetching scores: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch scores", e);
        }
    }
    
}