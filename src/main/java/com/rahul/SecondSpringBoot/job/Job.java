package com.rahul.SecondSpringBoot.job;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rahul.SecondSpringBoot.company.Company;
import jakarta.persistence.*;

import java.util.List;

@Entity
//@Table(name="job_table")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private String description;

    private String minSalary;

    private String maxSalary;
    private String location;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "comapany_id")
    private Company company;

    //NoArgConstructor -> jpa needs to create instances of entity class during the retieval of data
   //  from database jpa uses reflections to create instances of entity.
    public Job() {
    }

    public Job(Long id, String title, String description, String minSalary, String maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
