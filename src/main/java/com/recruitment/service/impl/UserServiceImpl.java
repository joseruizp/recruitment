package com.recruitment.service.impl;

import com.recruitment.entity.Applicant;
import com.recruitment.entity.Company;
import com.recruitment.entity.User;
import com.recruitment.repository.UserRepository;
import com.recruitment.service.ApplicantService;
import com.recruitment.service.CompanyService;
import com.recruitment.service.UserService;
import com.recruitment.util.UserType;
import com.recruitment.dto.view.UserView;
import com.recruitment.dto.util.ViewUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ApplicantService applicantService;
    private CompanyService companyService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ApplicantService applicantService, CompanyService companyService) {
        this.userRepository = userRepository;
        this.applicantService = applicantService;
        this.companyService = companyService;
    }

    @Override
    @Transactional
    public long createUser(UserView userView) {
        User user = ViewUtil.toUser(userView);
        User userSaved = userRepository.save(user);

        if (UserType.APPLICANT.name().equals(userView.getUserType())) {
            Applicant applicant = ViewUtil.toApplicant(userView.getApplicantView());
            applicant.setUser(userSaved);
            applicantService.saveApplicant(applicant);
        } else if (UserType.COMPANY.name().equals(userView.getUserType())) {
            Company company = ViewUtil.toCompany(userView.getCompanyView());
            company.setUser(userSaved);
            companyService.saveCompany(company);
        } else {
            throw new IllegalArgumentException("Tipo de usuario no definido: " + userView.getUserType());
        }

        return userSaved.getId();
    }
}
