package com.school_management_system.data_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school_management_system.data_management.models.User;
import com.school_management_system.data_management.repo.UserRepository;

import java.util.List;

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

    public void updateScore(String studentName, String subjectName, Integer newScore) {
        User user = userRepository.findByName(studentName);
        if(user!=null){
            user.getMarks().put(subjectName, newScore.toString());
            userRepository.save(user);
        }else{
            throw new RuntimeException("User not found");
        }
        
    }
}

