package com.example.drugs.model;

import javax.persistence.*;

@Entity
@Table(name="use_types")
public class UseType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    public UseType() {}

    public UseType(
            String name
    ) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
