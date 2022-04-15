package com.aston.mihail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    @Column(name = "login")
    private String login;
    @Column(name = "pass")
    private String password;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }
}
