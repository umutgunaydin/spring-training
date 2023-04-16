package com.company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private String address;
    private String city;
    private String state;


}
