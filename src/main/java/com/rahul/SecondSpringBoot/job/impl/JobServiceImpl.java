package com.rahul.SecondSpringBoot.job.impl;

import com.rahul.SecondSpringBoot.company.Company;
import com.rahul.SecondSpringBoot.company.CompanyRepository;
import com.rahul.SecondSpringBoot.job.*;
import org.aspectj.apache.bcel.classfile.Module;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;
    private ModelMapper model;
    private CompanyRepository companyRepository;
//    private List<Job> jobs = new ArrayList<>();
//    private Long nextId = 1L;


    public JobServiceImpl(JobRepository jobRepository,ModelMapper model,CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.model =model;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<JobDto> findAll() {

        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map((job) -> model.map(job,JobDto.class)).collect(Collectors.toList());
    }

    @Override
    public JobDto createdJob(JobDto jobDto) {
        Company company= companyRepository.findById(jobDto.getId())
                .orElseThrow(()->new ResourceNotFound("id","id",jobDto.getId()));

        Job job =model.map(jobDto,Job.class);
        Job savedJob = jobRepository.save(job);
        return model.map(savedJob, JobDto.class);
    }

    @Override
    public JobDto getJobById(Long id) {

        Job job = jobRepository.findById(id).orElseThrow(()-> new ResourceNotFound("job", "id", id));

        return model.map(job,JobDto.class);
    }
    @Override
    public JobDto updateJob(JobDto jobDto,Long id) {

             Job job = jobRepository.findById(id).orElseThrow(()-> new ResourceNotFound("job", "id", id));

          job.setTitle(jobDto.getTitle());
          job.setDescription(jobDto.getDescription());
          job.setMinSalary(jobDto.getMinSalary());
          job.setMaxSalary(jobDto.getMaxSalary());
          job.setLocation(job.getLocation());
          job.setId(id);

          Job updatedJob = jobRepository.save(job);

          return model.map(updatedJob,JobDto.class);


    }

    @Override
    public void deleteJob(Long id) {

        Job job = jobRepository.findById(id).orElseThrow(()-> new ResourceNotFound("job", "id", id));

        jobRepository.delete(job);

    }

}
