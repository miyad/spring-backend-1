package com.example.postgresspring1.person;
import lombok.Data;

import javax.persistence.*;

@Entity @Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

}
