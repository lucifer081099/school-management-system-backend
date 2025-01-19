package com.school_management_system.data_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school_management_system.data_management.dto.AuthRequest;
import com.school_management_system.data_management.dto.AuthResponse;
import com.school_management_system.data_management.service.AuthenticationService;


@RestController
@RequestMapping("/authenticate")
public class Authentication {

    @Autowired
    private AuthenticationService authenticationService;


    @GetMapping("/user")
    public AuthResponse authenticate(@RequestParam String username, 
                                   @RequestParam String password,
                                   @RequestParam String role) {
        AuthRequest request = new AuthRequest();
        request.setUsername(username);
        request.setPassword(password);
        request.setRole(role);
        return authenticationService.authenticate(request);
    }
}
