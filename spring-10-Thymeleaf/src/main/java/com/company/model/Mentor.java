package com.company.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mentor {
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private boolean graduated;
    private String batch;
    private String company;
}
