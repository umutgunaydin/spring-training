package com.company.dto;

import com.company.enums.EducationLevel;
import com.company.enums.Status;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDTO {

    @JsonIgnore
    private Long id;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    private String email;
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private LocalDate birthday;

    private Status status;

    private EducationLevel educationLevel;

    @JsonManagedReference(value = "teacher-address-reference")
    private AddressDTO address;

}