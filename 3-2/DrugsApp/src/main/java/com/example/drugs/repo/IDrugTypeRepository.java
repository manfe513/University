package com.example.drugs.repo;

import com.example.drugs.model.Drug;
import com.example.drugs.model.DrugType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDrugTypeRepository extends JpaRepository<DrugType, Long> {
}
