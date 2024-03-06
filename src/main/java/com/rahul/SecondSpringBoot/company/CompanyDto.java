package com.rahul.SecondSpringBoot.company;

import com.rahul.SecondSpringBoot.job.Job;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class CompanyDto {

    private Long id;
    private String name;
    private String description;

    @OneToMany
    private List<Job> jobs;

}
