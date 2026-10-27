package com.SpringBootProjects.ApplicantTrackingSystem.service;

import java.util.List;

import com.SpringBootProjects.ApplicantTrackingSystem.model.JobApplication;

public interface JobApplicationService {

    JobApplication createApplication(JobApplication application);

    List<JobApplication> getAllApplications();

    JobApplication getApplicationById(Long id);

    JobApplication updateApplication(Long id, JobApplication application);

    void deleteApplication(Long id);
}
