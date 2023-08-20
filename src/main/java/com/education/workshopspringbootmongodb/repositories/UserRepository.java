package com.education.workshopspringbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.education.workshopspringbootmongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
    
}
