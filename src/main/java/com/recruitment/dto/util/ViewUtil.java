package com.recruitment.dto.util;

import com.recruitment.dto.view.*;
import com.recruitment.entity.*;

import java.time.LocalDate;

public final class ViewUtil {

    public static Offer toOffer(OfferView offerView) {
        Offer offer = new Offer();
        offer.setTitle(offerView.getTitle());
        offer.setStartDate(offerView.getStartDate());
        offer.setEndDate(offerView.getEndDate());
        offer.setExpectedSalary(offerView.getExpectedSalary());
        offer.setPositionType(offerView.getPositionType());
        offer.setArea(offerView.getArea());
        offer.setDescription(offerView.getDescription());
        return offer;
    }

    public static JobApplication toJobApplication(JobApplicationView jobApplicationView) {
        return new JobApplication();
    }

    public static User toUser(UserView userView) {
        User user = new User();
        user.setEmail(userView.getEmail());
        user.setPassword(userView.getPassword());
        user.setCreationDate(LocalDate.now());
        user.setModificationDate(LocalDate.now());
        user.setUserType(userView.getUserType());
        return user;
    }

    public static Applicant toApplicant(ApplicantView applicantView) {
        Applicant applicant = new Applicant();
        applicant.setName(applicantView.getName());
        applicant.setLastName(applicantView.getLastName());
        applicant.setGender(applicantView.getGender());
        applicant.setBirthDate(applicantView.getBirthDate());
        applicant.setResume(applicantView.getResume());
        applicant.setLinkedInAccount(applicantView.getLinkedInAccount());
        applicant.setPhoto(applicantView.getPhoto());
        applicant.setPhoneNumber(applicantView.getPhoneNumber());
        applicant.setCellphoneNumber(applicantView.getCellphoneNumber());
        applicant.setAddress(applicantView.getAddress());
        applicant.setUbigeoCode(applicantView.getUbigeoCode());
        applicant.setDegree(applicantView.getDegree());
        applicant.setProfession(applicantView.getProfession());
        applicant.setInterests(applicantView.getInterests());
        applicant.setCv(applicantView.getCv());
        applicant.setUser(new User());
        applicant.getUser().setId(applicantView.getUserId());
        return applicant;
    }

    public static Company toCompany(CompanyView companyView) {
        Company company = new Company();
        company.setName(companyView.getName());
        company.setRuc(companyView.getRuc());
        company.setBusinessName(companyView.getBusinessName());
        company.setSector(companyView.getSector());
        company.setUrl(companyView.getUrl());
        company.setVideoLink(companyView.getVideoLink());
        company.setUser(new User());
        company.getUser().setId(companyView.getUserId());
        return company;
    }
}
