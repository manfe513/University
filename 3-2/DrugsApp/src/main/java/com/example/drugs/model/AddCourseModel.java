package com.example.drugs.model;

import java.util.Date;

public class AddCourseModel {

    private Long courseId;
    private Long drugId;
    private Long useTypeId;

    private Date dateStart;
    private Date dateEnd;

    private String time;

    public AddCourseModel() {}

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public Long getUseTypeId() {
        return useTypeId;
    }
    public void setUseTypeId(Long useTypeId) {
        this.useTypeId = useTypeId;
    }

    public Date getDateStart() {
        return dateStart;
    }
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
