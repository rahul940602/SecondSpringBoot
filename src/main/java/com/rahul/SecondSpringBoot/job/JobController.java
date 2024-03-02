package com.rahul.SecondSpringBoot.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){

        jobService.createdJob(job);
        return "Job Added Successfully";
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){

        return  jobService.findAll();
    }

    @GetMapping("/jobs/{id}")
    public  Job getJobsById(@PathVariable Long id){

        Job job = jobService.getJobById(id);

        return job;
    }


}
