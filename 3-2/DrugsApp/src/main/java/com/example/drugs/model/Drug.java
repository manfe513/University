package com.example.drugs.model;

import javax.persistence.*;

@Entity
@Table(name="drugs")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long id_drug_type;

    @Column
    private String name;

    @Column
    private String description;

    public Drug() {}

    public Drug(
            Long id_drug_type,
            String name,
            String description
    ) {
        this.id_drug_type = id_drug_type;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDrugType() {
        return id_drug_type;
    }

    public void setIdDrugType(Long id_drug_type) {
        this.id_drug_type = id_drug_type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
