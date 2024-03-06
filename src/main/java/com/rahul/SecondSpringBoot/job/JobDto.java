package com.rahul.SecondSpringBoot.job;

import com.rahul.SecondSpringBoot.company.Company;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class JobDto {

    private Long id;
    private String title;

    private String description;

    private String minSalary;

    private String maxSalary;
    private String location;
    @ManyToOne
    private Company company;

}
