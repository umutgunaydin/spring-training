package com.company.entity;

import com.company.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "students")//naming the table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "studentFirstName")//column naming
    private String firstName; // camel casing will automatically be converted to snake casing for db
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime birthDateTime;

    @Enumerated(EnumType.STRING)// saves value of enums
//    @Enumerated(EnumType.ORDINAL)// saves int of enums -- default one
    private Gender gender;

    @Transient // does not create column
    private String city;

}
