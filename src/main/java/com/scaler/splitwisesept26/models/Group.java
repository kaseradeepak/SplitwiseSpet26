package com.scaler.splitwisesept26.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "groups")
public class Group extends BaseModel {
    private String title;
    private String description;

    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;

    @ManyToMany
    private List<User> users;

    @ManyToOne
    private User admin;
}
