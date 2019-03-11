package com.recruitment.service.impl;

import com.recruitment.entity.Company;
import com.recruitment.repository.CompanyRepository;
import com.recruitment.service.CompanyService;
import com.recruitment.dto.view.CompanyView;
import com.recruitment.dto.util.ViewUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company getCompany(long id) {
        Optional<Company> company = companyRepository.findById(id);

        if (!company.isPresent()) {
            throw new RuntimeException("Empresa no encontrada con el id: " + id);
        }

        return company.get();
    }

    @Override
    @Transactional
    public long saveCompany(CompanyView companyView) {
        Company company = ViewUtil.toCompany(companyView);

        return saveCompany(company);
    }

    @Override
    @Transactional
    public long saveCompany(Company company) {
        Company savedCompany = companyRepository.save(company);

        return savedCompany.getId();
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

}
