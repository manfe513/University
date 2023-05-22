package com.example.drugs.service;

import com.example.drugs.model.Course;
import com.example.drugs.repo.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    ICourseRepository repo;

    public Course getById(Long id) {
        return repo.findById(id).get();
    }

    public List<Course> getAll() {
        return repo.findAll();
    }

    public boolean saveOrUpdate(Course user) {
        Course updated = repo.save(user);

        return repo.findById(updated.getId()).isPresent();
    }
}
