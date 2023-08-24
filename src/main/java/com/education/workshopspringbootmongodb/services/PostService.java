package com.education.workshopspringbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.workshopspringbootmongodb.domain.Post;
import com.education.workshopspringbootmongodb.repositories.PostRepository;
import com.education.workshopspringbootmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }
}
