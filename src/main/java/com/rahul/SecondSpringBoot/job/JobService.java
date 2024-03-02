package com.rahul.SecondSpringBoot.job;

import java.util.ArrayList;
import java.util.List;

public interface JobService {


   List<Job> findAll();
   void createdJob(Job job);

   Job getJobById(Long id);

   boolean deleteJobById(Long id);

}
