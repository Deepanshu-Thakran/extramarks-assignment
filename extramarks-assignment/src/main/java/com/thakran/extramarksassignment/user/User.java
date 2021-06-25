package com.thakran.extramarksassignment.user;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String mobile;
    private String state;
    private String gender;
    private String skills;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String  getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }


    public User() {
    }

    public User(Long id, String name, String email, String mobile, String state, String gender, String skills) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.state = state;
        this.gender = gender;
        this.skills = skills;

    }

    public User(String name, String email, String mobile, String state, String gender, String skills) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.state = state;
        this.gender = gender;
        this.skills = skills;
    }



    public User(String name, String email, String mobile, String state, String gender) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.state = state;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", state='" + state + '\'' +
                ", gender='" + gender + '\'' +
                ", skills=" + skills +'\''+
                '}';
    }
}
