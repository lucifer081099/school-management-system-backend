package com.school_management_system.data_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school_management_system.data_management.dto.AuthRequest;
import com.school_management_system.data_management.dto.AuthResponse;
import com.school_management_system.data_management.models.Credential;

@Service
public class AuthenticationService {
    @Autowired
    private CredentialService credentialService;
    
    public AuthResponse authenticate(AuthRequest request) {
        Credential cred= credentialService.getCredentialByUsername(request.getUsername());
        if(cred!=null){
            if(cred.getPassword().equals(request.getPassword()) && cred.getRole().equals(request.getRole())){
                AuthResponse response = new AuthResponse();
                response.setAuthenticated(true);
                response.setMessage("Authentication successful");
                return response;
            }else{
                AuthResponse response = new AuthResponse();
                response.setAuthenticated(false);
                response.setMessage("Invalid credentials");
                return response;
            }
        }
        AuthResponse response = new AuthResponse();
        response.setAuthenticated(false);
        response.setMessage("Invalid credentials");
        return response;
        
    }
}