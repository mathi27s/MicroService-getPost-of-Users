package com.example.demo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
public class post {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
