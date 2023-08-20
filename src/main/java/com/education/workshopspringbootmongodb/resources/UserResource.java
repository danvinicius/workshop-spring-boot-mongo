package com.education.workshopspringbootmongodb.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.workshopspringbootmongodb.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("teste", "Maria", "maria@test.com");
        List<User> users = new ArrayList<User>();
        users.add(0, maria);
        return ResponseEntity.ok().body(users);
    }
    
}
