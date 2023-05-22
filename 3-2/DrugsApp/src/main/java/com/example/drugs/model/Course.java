package com.example.drugs.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long id_drug;

    @Column
    private Long id_use_type;

    @Column
    private Date date_start;

    @Column
    private Date date_end;

    @Column
    private String time;

    public Course() {}

    public Course(
            Long id_drug,
            Long id_use_type,
            Date date_start,
            Date date_end,
            String time
    ) {
        this.id_drug = id_drug;
        this.id_use_type = id_use_type;
        this.date_start = date_start;
        this.date_end = date_end;
        this.time = time;
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

    public Date getDate_start() {
        return date_start;
    }

    public void setDate_start(Date date_start) {
        this.date_start = date_start;
    }

    public Date getDate_end() {
        return date_end;
    }

    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
