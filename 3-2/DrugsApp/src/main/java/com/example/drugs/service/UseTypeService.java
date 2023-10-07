package com.example.drugs.service;

import com.example.drugs.model.UseType;
import com.example.drugs.repo.IUseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UseTypeService {

    @Autowired
    IUseTypeRepository repo;

    public List<UseType> getAll() {
        return repo.findAll();
    }

    public UseType getById(Long id) {
        return repo.findById(id).get();
    }
}
