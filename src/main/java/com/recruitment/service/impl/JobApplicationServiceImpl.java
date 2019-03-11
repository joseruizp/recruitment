package com.recruitment.service.impl;

import com.recruitment.entity.Applicant;
import com.recruitment.entity.JobApplication;
import com.recruitment.entity.Offer;
import com.recruitment.repository.JobApplicationRepository;
import com.recruitment.service.ApplicantService;
import com.recruitment.service.JobApplicationService;
import com.recruitment.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    @Transactional
    public long apply(long applicantId, long offerId) {
        JobApplication jobApplication = new JobApplication();
        jobApplication.setApplicant(new Applicant());
        jobApplication.getApplicant().setId(applicantId);
        jobApplication.setOffer(new Offer());
        jobApplication.getOffer().setId(offerId);
        jobApplication.setCreationDate(new Date());

        JobApplication jobApplicationSaved = jobApplicationRepository.save(jobApplication);
        return jobApplicationSaved.getId();
    }

    @Override
    public List<JobApplication> getAllApplications() {
        return jobApplicationRepository.findAll();
    }

    @Override
    public JobApplication getApplication(long id) {
        Optional<JobApplication> jobApplication = jobApplicationRepository.findById(id);

        if (!jobApplication.isPresent()) {
            throw new RuntimeException("Aplicacion al puesto no encontrado con id: " + id);
        }

        return jobApplication.get();
    }
}
