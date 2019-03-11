package com.recruitment.dto.view;

import lombok.Data;

@Data
public class UserView {

    private String email;
    private String password;
    private String userType;
    private ApplicantView applicantView;
    private CompanyView companyView;
}
