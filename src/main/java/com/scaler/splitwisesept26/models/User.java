package com.scaler.splitwisesept26.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel {
    private String name;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    private String password;
}