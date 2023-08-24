package com.education.workshopspringbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.education.workshopspringbootmongodb.domain.Post;
import java.util.List;


public interface PostRepository extends MongoRepository<Post, String> {
    
    List<Post> findByTitleContainingIgnoreCase(String text);

}
