package com.example.drugs.model;

import javax.persistence.*;

@Entity
@Table(name="CATEGORYANIME")
public class CategoryAnime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int animeid;


    @Column
    private String denomination;



    public CategoryAnime() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAnimeid() { return (long) animeid; }

    public void setAnimeid(String animeid) {
        this.animeid = Integer.parseInt(animeid);
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

}
