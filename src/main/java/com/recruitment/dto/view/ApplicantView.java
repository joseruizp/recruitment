package com.recruitment.dto.view;

import lombok.Data;

import java.util.Date;

@Data
public class ApplicantView {

    private String name;
    private String lastName;
    private String gender;
    private Date birthDate;
    private String resume;
    private String linkedInAccount;
    private String photo;
    private String phoneNumber;
    private String cellphoneNumber;
    private String address;
    private String ubigeoCode;
    private String degree;
    private String profession;
    private String interests;
    private byte[] cv;
    private long userId;

}
