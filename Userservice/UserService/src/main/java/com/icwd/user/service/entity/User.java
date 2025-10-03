package com.icwd.user.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User {


    @Id
    private String userId;
    @Column(nullable = false)
    private String first_Name;
    @Column(nullable = false)
    private String last_Name;
    @Column(nullable = false)
    private String user_Email;

    @Transient
    private List<Ratings> ratings ;


    public User(String userId, String first_Name, String last_Name, String user_Email, List<Ratings> ratings) {
        this.userId = userId;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.user_Email = user_Email;
        this.ratings = ratings;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    public List<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(List<Ratings> ratings) {
        this.ratings = ratings;
    }
}
