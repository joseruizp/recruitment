package com.recruitment.dto.view;

import lombok.Data;

import java.util.Date;

@Data
public class OfferView {

    private long companyId;
    private String title;
    private Date startDate;
    private Date endDate;
    private double expectedSalary;
    private String positionType;
    private String area;
    private String description;

}
