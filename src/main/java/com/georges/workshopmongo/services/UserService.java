package com.georges.workshopmongo.services;

import com.georges.workshopmongo.domain.User;
import com.georges.workshopmongo.repository.UserRepository;
import com.georges.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Obejeto não encontrado!"));
        return user;
    }
}
