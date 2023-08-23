package com.education.workshopspringbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.education.workshopspringbootmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    
}
