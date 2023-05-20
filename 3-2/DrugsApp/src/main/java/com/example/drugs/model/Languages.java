package com.example.drugs.model;

import javax.persistence.*;

@Entity
@Table(name="LANGUAGES")
public class Languages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int animeid;

    @Column
    private String title;

    @Column
    private String code;

    public Languages() {

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() { return code; }

    public void setCode(String code) {
        this.code = code;
    }
}
