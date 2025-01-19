package com.school_management_system.data_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school_management_system.data_management.models.Credential;
import com.school_management_system.data_management.repo.CredentialRepository;

import java.util.List;

@Service
public class CredentialService {

    @Autowired(required=true)
    private CredentialRepository credentialRepository;

    public Credential saveCredential(Credential credential) {
        return credentialRepository.save(credential);
    }

    public Credential getCredentialByUsername(String username) {
        return credentialRepository.findByUsername(username);
    }
}

