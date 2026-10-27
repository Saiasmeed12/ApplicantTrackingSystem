package com.SpringBootProjects.ApplicantTrackingSystem.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootProjects.ApplicantTrackingSystem.model.JobApplication;
import com.SpringBootProjects.ApplicantTrackingSystem.service.JobApplicationService;

@RestController
@RequestMapping("/ats")
@CrossOrigin(origins = "http://localhost:5173")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }
    
    @GetMapping("/welcome")
	String Welcome() {
		return "Welcome to Applicant Tracking System";
	}

    // Create a job application
    @PostMapping("/createJobApplication")
    public ResponseEntity<JobApplication> createApplication(
            @RequestBody JobApplication application) {

        JobApplication saved = service.createApplication(application);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // Get all job applications
    @GetMapping("/getAllJobsApplications")
    public ResponseEntity<List<JobApplication>> getAllApplications() {

        return ResponseEntity.ok(service.getAllApplications());
    }

    // Get a job application by ID
    @GetMapping("/getJobApplicationById/{id}")
    public ResponseEntity<JobApplication> getApplicationById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getApplicationById(id));
    }

    // Update a job application
    @PutMapping("/updateJobApplication/{id}")
    public ResponseEntity<JobApplication> updateApplication(
            @PathVariable Long id,
            @RequestBody JobApplication application) {

        return ResponseEntity.ok(
                service.updateApplication(id, application));
    }

    // Delete a job application
    @DeleteMapping("/deleteJobApplication/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {

        service.deleteApplication(id);

        return ResponseEntity.noContent().build();
    }
}

