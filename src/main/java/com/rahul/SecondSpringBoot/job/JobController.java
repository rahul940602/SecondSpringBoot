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

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable Long id){

        boolean deleted =  jobService.deleteJobById(id);

         if(deleted)
             return  new ResponseEntity<>("Job Deleted Successfully",HttpStatus.OK);

         return new ResponseEntity<>("Job Not Found",HttpStatus.NOT_FOUND);


    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,
                                            @RequestBody Job updateJob){
        boolean updated = jobService.updateJob(id,updateJob);

        if(updated)
            return  new ResponseEntity<>("Updated Job Successfully", HttpStatus.OK);

        return  new ResponseEntity<>("Job NoT Found", HttpStatus.NOT_FOUND);

    }

}
