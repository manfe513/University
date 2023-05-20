package com.example.drugs.model;

import javax.persistence.*;

@Entity
@Table(name="REVIEWS")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int humanid;

    @Column
    private int animeid;

    @Column
    private String firstName;

    @Column
    private String review;

    public Reviews() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHumanid() { return (long) humanid; }

    public void setHumanid(String humanid) {
        this.humanid = Integer.parseInt(humanid);
    }

    public Long getAnimeid() { return (long) animeid; }

    public void setAnimeid(String animeid) {
        this.animeid = Integer.parseInt(animeid);
    }

    public String getFirstName() { return firstName;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getReview() { return review; }

    public void setReviews(String review) {
        this.review = review;
    }
}
