package com.example.drugs.model;

import javax.persistence.*;

@Entity
@Table(name="IMAGE")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String imagepath;

    @Column
    private int animeid;

    public Image() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagepath() { return imagepath; }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public Long getAnimeid() { return (long) animeid; }

    public void setAnimeid(String animeid) {
        this.animeid = Integer.parseInt(animeid);
    }

}
