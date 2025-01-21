package com.school_management_system.data_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school_management_system.data_management.models.User;
import com.school_management_system.data_management.repo.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired(required=true)
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getUserByHouse(String house) {
        return userRepository.findByHouse(house);
    }

    public void updateScore(String studentName, String subjectName, Integer newScore) {
        System.out.println("Subject Name: " + subjectName);
        User user = userRepository.findByName(studentName);
        System.out.println("user: " + user.toString());
        if(user!=null){
            if(subjectName.equals("Mathematics")){
                System.out.println("Enrolling student in Mathematics");
                user.setMathematics(String.valueOf(newScore));
            }else if(subjectName.equals("Science")){
                System.out.println("Enrolling student in Science");
                user.setScience(String.valueOf(newScore));

            }else if(subjectName.equals("English")){
                System.out.println("Enrolling student in English");
                user.setEnglish(String.valueOf(newScore));

            }else if(subjectName.equals("History")){
                System.out.println("Enrolling student in History");

                user.setHistory(String.valueOf(newScore));
            }else if(subjectName.equals("Hindi")){
                System.out.println("Enrolling student in Hindi");
                user.setHindi(String.valueOf(newScore));
            }else if(subjectName.equals("Economics")){   
                System.out.println("Enrolling student in Economics"); 
                user.setEconomics(String.valueOf(newScore));
            }
            System.out.println("user"+user.toString());
        
            userRepository.save(user);
        }
        
    }

    public List<User> getAllUsers() {
        try {
            System.out.println("Fetching all users from repository");
            List<User> users = StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
            System.out.println("Found " + users.size() + " users");
            return users;
        } catch (Exception e) {
            System.err.println("Error in getAllUsers: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch users", e);
        }
    }

    public List<User> getAllUsersSorted() {
        return userRepository.findAllByOrderByNameAsc();
    }
}

