package com.recruitment.service;

import com.recruitment.entity.JobApplication;

import java.util.List;

public interface JobApplicationService {

    public long apply(long applicantId, long offerId);
    public List<JobApplication> getAllApplications();
    public JobApplication getApplication(long id);
}
