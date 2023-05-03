package com.company.entity;

import com.company.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    @Column(columnDefinition = "DATE")
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;
    @ManyToOne
    @JoinColumn(name = "department") // department_id is default one
    private Department department;
    @ManyToOne
    @JoinColumn(name = "region_id") // department_id is default one
    private Region region;



}
