package com.school_management_system.data_management.repo;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.school_management_system.data_management.models.User;

import java.util.List;

@Repository
public interface UserRepository extends SolrCrudRepository<User, String> {
    User findByName(String name);
    List<User> findByHouse(String house);

    @Query("*:*")
    List<User> findAll();

    @Query(value = "*:*")
    List<User> findAllUsers();
    
    List<User> findAllByOrderByNameAsc();
}
