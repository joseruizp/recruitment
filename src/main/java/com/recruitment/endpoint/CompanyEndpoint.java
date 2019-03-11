package com.recruitment.endpoint;

import com.recruitment.entity.Company;
import com.recruitment.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class CompanyEndpoint {

    private CompanyService companyService;

    @Autowired
    public CompanyEndpoint(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public List<Company> retrieveAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/companies/{id}")
    @ApiOperation(value = "Find company by id",
            notes = "Also returns a link to retrieve all companies with rel - all-companies")
    public Resource<Company> getOffer(@PathVariable long id) {
        Company company = companyService.getCompany(id);

        Resource<Company> resource = new Resource<>(company);

        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllCompanies());

        resource.add(linkTo.withRel("all-companies"));

        return resource;
    }
}
