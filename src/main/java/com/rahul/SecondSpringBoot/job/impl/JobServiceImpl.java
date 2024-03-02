package com.rahul.SecondSpringBoot.job.impl;

import com.rahul.SecondSpringBoot.job.Job;
import com.rahul.SecondSpringBoot.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createdJob(Job job) {

       jobs.add(job);

    }
}
