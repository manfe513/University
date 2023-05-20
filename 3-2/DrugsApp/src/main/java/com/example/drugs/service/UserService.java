package com.example.drugs.service;

import com.example.drugs.model.User;
import com.example.drugs.repo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    IUserRepository repo;

    public User getById(Long id) {
        return repo.findById(id).get();
    }

    public boolean saveOrUpdate(User user) {
        User updated = repo.save(user);

        return repo.findById(updated.getId()).isPresent();
    }
}
