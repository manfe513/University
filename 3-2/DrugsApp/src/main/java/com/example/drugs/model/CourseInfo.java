package com.example.drugs.model;

public class CourseInfo {

    private Course course;

    private Drug drug;

    private DrugType drugType;

    private UseType useType;

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
}
