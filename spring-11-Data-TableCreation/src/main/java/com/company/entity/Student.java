package com.company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private Long id;
    private String firstName; // camel casing will automatically be converted to snake casing for db
    private String lastName;
    private String email;



}
