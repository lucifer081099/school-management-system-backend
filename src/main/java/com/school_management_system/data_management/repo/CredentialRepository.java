package com.school_management_system.data_management.repo;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.school_management_system.data_management.models.Credential;


@Repository
public interface CredentialRepository extends SolrCrudRepository<Credential, String> {
    Credential findByUsername(String username);
}

