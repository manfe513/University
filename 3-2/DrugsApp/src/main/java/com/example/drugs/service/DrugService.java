package com.example.drugs.service;

import com.example.drugs.model.Drug;
import com.example.drugs.repo.IDrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugService {

    @Autowired
    IDrugRepository repo;

    public List<Drug> getAll() {
        return repo.findAll();
    }

    public Drug getById(Long id) {
        return repo.findById(id).get();
    }

    public boolean saveOrUpdate(Drug item) {
        Drug updated = repo.save(item);

        return repo.findById(updated.getId()).isPresent();
    }
}
