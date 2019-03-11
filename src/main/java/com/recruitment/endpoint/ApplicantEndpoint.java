package com.recruitment.endpoint;

import com.recruitment.entity.Applicant;
import com.recruitment.entity.Company;
import com.recruitment.service.ApplicantService;
import com.recruitment.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class ApplicantEndpoint {

    private ApplicantService applicantService;

    @Autowired
    public ApplicantEndpoint(ApplicantService companyService) {
        this.applicantService = companyService;
    }

    @GetMapping("/applicants")
    public List<Applicant> retrieveAllApplicants() {
        return applicantService.retrieveAllApplicants();
    }

    @GetMapping("/applicants/{id}")
    @ApiOperation(value = "Find applicant by id",
            notes = "Also returns a link to retrieve all applicants with rel - all-applicants")
    public Resource<Applicant> getOffer(@PathVariable long id) {
        Applicant applicant = applicantService.getApplicant(id);

        Resource<Applicant> resource = new Resource<>(applicant);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllApplicants());

        resource.add(linkTo.withRel("all-applicants"));

        return resource;
    }
}
