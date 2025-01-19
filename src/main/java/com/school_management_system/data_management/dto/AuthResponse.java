package com.school_management_system.data_management.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private boolean authenticated;
    private String message;
}
