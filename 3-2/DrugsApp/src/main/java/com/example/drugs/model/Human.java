package com.example.drugs.model;

import javax.persistence.*;

@Entity
@Table(name="HUMAN")
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int usersid;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private int age;

    public Human() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsersid() { return (long) usersid; }

    public void setUsersid(String usersid) {
        this.usersid = Integer.parseInt(usersid);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}