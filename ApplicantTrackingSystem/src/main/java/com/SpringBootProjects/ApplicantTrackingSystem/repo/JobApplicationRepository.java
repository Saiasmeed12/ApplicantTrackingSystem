package com.SpringBootProjects.ApplicantTrackingSystem.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootProjects.ApplicantTrackingSystem.model.JobApplication;


public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {

}

