package com.example.drugs.model;

import javax.persistence.*;
import java.util.Date;

public class CourseFull {

    private Course course;

    private Drug drug;

    public CourseFull() {}

    public CourseFull(
            Course course,
            Drug drug
    ) {
        this.course = course;
        this.drug = drug;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDrug() {
        return id_drug;
    }

    public void setIdDrug(Long id_drug) {
        this.id_drug = id_drug;
    }
    public Long getIdUseType() {
        return id_use_type;
    }

    public void setIdUseType(Long id_use_type) {
        this.id_use_type = id_use_type;
    }
}
