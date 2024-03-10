package com.rahul.SecondSpringBoot.review;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rahul.SecondSpringBoot.company.Company;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ReviewDto {

    private Long id;
    private String title;
    private String description;
    private double rating;
    @JsonIgnore
    @ManyToOne
    private Company company;
}
