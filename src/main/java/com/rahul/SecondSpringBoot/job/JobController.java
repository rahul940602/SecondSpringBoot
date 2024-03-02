package com.rahul.SecondSpringBoot.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JobController {

    private List<Job> jobs = new ArrayList<>();

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){

        jobs.add(job);
        return "Job Added Successfully";
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){

        return  jobs;

    }


}
