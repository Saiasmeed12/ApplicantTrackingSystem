package com.SpringBootProjects.ApplicantTrackingSystem.service;
import java.util.List;

import org.springframework.stereotype.Service;
import com.SpringBootProjects.ApplicantTrackingSystem.model.JobApplication;
import com.SpringBootProjects.ApplicantTrackingSystem.repo.JobApplicationRepository;
import com.SpringBootProjects.ApplicantTrackingSystem.service.JobApplicationService;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationServiceImpl(JobApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public JobApplication createApplication(JobApplication application) {
        return repository.save(application);
    }

    @Override
    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }

    @Override
    public JobApplication getApplicationById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Job application not found with ID: " + id));
    }

    @Override
    public JobApplication updateApplication(Long id, JobApplication application) {
        JobApplication existing = getApplicationById(id);

        existing.setCompanyName(application.getCompanyName());
        existing.setJobTitle(application.getJobTitle());
        existing.setJobLocation(application.getJobLocation());
        existing.setJobType(application.getJobType());
        existing.setStatus(application.getStatus());
        existing.setAppliedDate(application.getAppliedDate());
        existing.setJobUrl(application.getJobUrl());
        existing.setNotes(application.getNotes());

        return repository.save(existing);
    }

    @Override
    public void deleteApplication(Long id) {
        JobApplication existing = getApplicationById(id);
        repository.delete(existing);
    }
}

