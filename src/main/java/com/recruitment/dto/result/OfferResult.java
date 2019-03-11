package com.recruitment.dto.result;

import lombok.Data;

import java.util.Date;

@Data
public class OfferResult {

    private long id;
    private String title;
    private Date startDate;
    private Date endDate;
    private double expectedSalary;
    private String positionType;
    private String area;
    private String description;
    private KeyValueResult company;

}
