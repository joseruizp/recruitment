package com.recruitment.endpoint;

import com.recruitment.entity.JobApplication;
import com.recruitment.service.JobApplicationService;
import com.recruitment.dto.view.JobApplicationView;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class JobApplicationEndpoint {

    private JobApplicationService jobApplicationService;

    @Autowired
    public JobApplicationEndpoint(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @GetMapping("/applications")
    public List<JobApplication> retrieveAllApplications() {
        return jobApplicationService.getAllApplications();
    }

    @GetMapping("/applications/{id}")
    @ApiOperation(value = "Find job application by id",
            notes = "Also returns a link to retrieve all offers with rel - all-applications")
    public Resource<JobApplication> getJobApplication(@PathVariable long id) {
        JobApplication jobApplication = jobApplicationService.getApplication(id);

        Resource<JobApplication> resource = new Resource<JobApplication>(jobApplication);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllApplications());

        resource.add(linkTo.withRel("all-applications"));

        return resource;
    }

    @PostMapping("/applications/")
    public ResponseEntity<Object> createOffer(@RequestBody JobApplicationView jobApplicationView) {

        jobApplicationService.apply(jobApplicationView.getApplicantId(), jobApplicationView.getOfferId());

        return ResponseEntity.noContent().build();
    }
}
