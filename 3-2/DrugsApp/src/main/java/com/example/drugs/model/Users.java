package com.example.drugs.model;

import javax.persistence.*;

@Entity
@Table(name="USERS")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private int animeid;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String email;


    public Users() {

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

    public String getLogin() { return login; }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

}
