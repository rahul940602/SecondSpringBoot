package com.rahul.SecondSpringBoot.job.impl;

import com.rahul.SecondSpringBoot.job.Job;
import com.rahul.SecondSpringBoot.job.JobRepository;
import com.rahul.SecondSpringBoot.job.JobService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;
//    private List<Job> jobs = new ArrayList<>();
//    private Long nextId = 1L;


    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createdJob(Job job) {
//       job.setId(nextId++);
        jobRepository.save(job);

    }

    @Override
    public Job getJobById(Long id) {

        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
  try {
      jobRepository.deleteById(id);
      return true;
  }catch (Exception ex){
      return false;
  }

    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {

        Optional<Job> jobOptional = jobRepository.findById(id);


            if(jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(updateJob.getTitle());
                job.setDescription(updateJob.getDescription());
                job.setMinSalary(updateJob.getMinSalary());
                job.setMaxSalary(updateJob.getMaxSalary());
                job.setLocation(updateJob.getLocation());
                 jobRepository.save(job);
                return true;
            }

        return false;
    }
}
