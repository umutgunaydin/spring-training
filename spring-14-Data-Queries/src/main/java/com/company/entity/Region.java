package com.company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "regions")
@NoArgsConstructor
@Data
public class Region extends BaseEntity{

    private String region;
    private String country;

}
