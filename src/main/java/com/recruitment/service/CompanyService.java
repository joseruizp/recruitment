package com.recruitment.service;

import com.recruitment.entity.Company;
import com.recruitment.dto.view.CompanyView;

import java.util.List;

public interface CompanyService {

    Company getCompany(long id);
    long saveCompany(CompanyView companyView);
    long saveCompany(Company company);
    List<Company> getAllCompanies();
}
