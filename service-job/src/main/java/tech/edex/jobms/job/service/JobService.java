package tech.edex.jobms.job.service;

import tech.edex.jobms.job.model.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJob(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
