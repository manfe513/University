package com.example.drugs.repo;

import com.example.drugs.model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDrugRepository extends JpaRepository<Drug, Long> {
}
