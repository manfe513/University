package com.example.drugs.service;

import com.example.drugs.model.Drug;
import com.example.drugs.model.DrugType;
import com.example.drugs.repo.IDrugRepository;
import com.example.drugs.repo.IDrugTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugTypeService {

    @Autowired
    IDrugTypeRepository repo;

    public List<DrugType> getAll() {
        return repo.findAll();
    }

    public DrugType getById(Long id) {
        return repo.findById(id).get();
    }
}
