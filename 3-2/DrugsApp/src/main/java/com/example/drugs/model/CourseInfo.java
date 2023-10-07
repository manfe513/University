package com.example.drugs.model;

import java.util.Date;

public class CourseInfo {

    private Course course;

    private Drug drug;

    private DrugType drugType;

    private UseType useType;

    private Date dateStart;
    private Date dateEnd;

    public CourseInfo() {}

    public CourseInfo(
            Course course,
            Drug drug,
            DrugType drugType,
            UseType useType
    ) {
        this.course = course;
        this.drug = drug;
        this.drugType = drugType;
        this.useType = useType;
    }

    public Course getCourse() {
        return course;
    }

    public Drug getDrug() {
        return drug;
    }

    public DrugType getDrugType() {
        return drugType;
    }

    public UseType getUseType() {
        return useType;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }
}
