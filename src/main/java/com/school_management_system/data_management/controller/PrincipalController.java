package com.school_management_system.data_management.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.school_management_system.data_management.models.Credential;
import com.school_management_system.data_management.service.CredentialService;
import com.school_management_system.data_management.service.UserService;
import com.school_management_system.data_management.models.User;


@RestController
@RequestMapping("/principal")
public class PrincipalController {

    
    @Autowired
    private CredentialService credentialService;

    @Autowired
    private UserService userService;
   

    // Endpoint to create a student and principal database
    @RequestMapping("/enroll")
    public void enrollInSubject() { 
        System.out.println("Student ID: ");
        Credential credential = new Credential();
        credential.setName("principal");
        credential.setUsername("principal");
        credential.setPassword("password");
        credential.setRole("principal");
        credentialService.saveCredential(credential);

        List<User> usersRed = userService.getUserByHouse("Red");
        List<User> usersBlue = userService.getUserByHouse("Blue");
        List<User> usersGreen = userService.getUserByHouse("Green");
        List<User> usersYellow = userService.getUserByHouse("Yellow");
        List<User> users = new ArrayList<>();
        users.addAll(usersRed);
        users.addAll(usersBlue);
        users.addAll(usersGreen);
        users.addAll(usersYellow);
        for(int i=0;i<users.size();i++){
            Credential credential1 = new Credential();
            credential1.setName(users.get(i).getName());
            credential1.setUsername(users.get(i).getUsername());
            credential1.setPassword(users.get(i).getUsername());
            credential1.setRole("student");
            credentialService.saveCredential(credential1);
        }


        Credential credential2 = credentialService.getCredentialByUsername("principal");
        System.out.println(credential2.getName());



    }

    @RequestMapping("/enrollstudents")
    public void enrollInStudents() {
        Random random = new Random();
        String[] houses = {"Red", "Blue", "Green", "Yellow"};
        String[] classes = {"1A", "1B", "2A", "2B", "3A", "3B"};
        
        try {
            for(int i = 0; i < 125; i++) {
                User user = new User();
                user.setName("student" + i);
                user.setUsername("student" + i);
                user.setRollNumber(String.format("%03d", i + 1));
                user.setUserClass(classes[random.nextInt(classes.length)]);
                user.setHouse(houses[random.nextInt(houses.length)]);
                
                user.setClassAllocated(null);
                user.setSeatColumn(null);
                user.setSeatRow(null);
                user.setEnglish(String.valueOf(60 + random.nextInt(41)));
                user.setHindi(String.valueOf(60 + random.nextInt(41)));
                user.setMathematics(String.valueOf(60 + random.nextInt(41)));
                user.setScience(null);
                user.setHistory(null);
                user.setEconomics(null);

                System.out.println(user.toString());
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

    @PostMapping("/allocate-seat")
    public void allocateSeat(@RequestParam String studentUsername,@RequestParam String classroomName, 
                                   @RequestParam Integer seatRow,@RequestParam Integer seatColumn) throws Exception {

        System.out.println("inside allocate seat"+studentUsername+classroomName+seatRow+seatColumn);
        userService.allocateSeat(studentUsername, classroomName, seatRow, seatColumn);
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