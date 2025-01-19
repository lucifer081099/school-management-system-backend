package com.school_management_system.data_management.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
    private String role;
    
}
