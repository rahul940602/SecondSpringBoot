package com.rahul.SecondSpringBoot.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createJob(@RequestBody Job job){

        jobService.createdJob(job);
        return new ResponseEntity<>( "Job Added Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){

        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK) ;
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobsById(@PathVariable Long id){

        Job job = jobService.getJobById(id);

        if(job != null)
         return new ResponseEntity<>(job, HttpStatus.OK);


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
