package com.example.drugs.model;

import javax.persistence.*;

@Entity
@Table(name="drug_types")
public class DrugType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String type;
    public DrugType() {}

    public DrugType(
            String type
    ) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
