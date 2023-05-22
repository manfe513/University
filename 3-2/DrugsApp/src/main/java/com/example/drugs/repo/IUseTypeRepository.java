package com.example.drugs.repo;

import com.example.drugs.model.UseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUseTypeRepository extends JpaRepository<UseType, Long> {
}
