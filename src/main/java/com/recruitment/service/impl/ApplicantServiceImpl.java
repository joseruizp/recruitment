package com.recruitment.service.impl;

import com.recruitment.entity.Applicant;
import com.recruitment.repository.ApplicantRepository;
import com.recruitment.service.ApplicantService;
import com.recruitment.dto.view.ApplicantView;
import com.recruitment.dto.util.ViewUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicantServiceImpl implements ApplicantService{

    private ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public Applicant getApplicant(long id) {

        Optional<Applicant> applicant = applicantRepository.findById(id);

        if (!applicant.isPresent()) {
            throw new RuntimeException("Postulante no encontrado con id: " + id);
        }

        return applicant.get();
    }

    @Override
    @Transactional
    public long saveApplicant(ApplicantView applicantView) {
        Applicant applicant = ViewUtil.toApplicant(applicantView);

        return saveApplicant(applicant);
    }

    @Override
    @Transactional
    public long saveApplicant(Applicant applicant) {
        Applicant savedApplicant = applicantRepository.save(applicant);

        return savedApplicant.getId();
    }

    @Override
    public List<Applicant> retrieveAllApplicants() {
        return applicantRepository.findAll();
    }
}
