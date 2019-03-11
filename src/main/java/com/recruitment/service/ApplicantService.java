package com.recruitment.service;

import com.recruitment.entity.Applicant;
import com.recruitment.dto.view.ApplicantView;

import java.util.List;

public interface ApplicantService {

    Applicant getApplicant(long id);
    long saveApplicant(ApplicantView applicantView);
    long saveApplicant(Applicant applicant);
    List<Applicant> retrieveAllApplicants();
}
