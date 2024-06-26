package com.education.workshopspringbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.education.workshopspringbootmongodb.domain.User;
import com.education.workshopspringbootmongodb.dto.UserDTO;
import com.education.workshopspringbootmongodb.repositories.UserRepository;
import com.education.workshopspringbootmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
    }

    public User insert(User user) {
        return repository.insert(user);
    }

    public void delete(String id) {
        User user = findById(id);
        repository.delete(user);
    }
    
    public User update(User obj) {
        User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
    }

    public void updateData(User newObj, User obj) {
        if (obj.getName() != null && !obj.getName().isEmpty()) {
            newObj.setName(obj.getName());
        }
        if (obj.getEmail() != null && !obj.getEmail().isEmpty()) {
            newObj.setEmail(obj.getEmail());
        }
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    
}
