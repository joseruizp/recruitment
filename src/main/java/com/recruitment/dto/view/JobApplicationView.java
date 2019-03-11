package com.recruitment.dto.view;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class JobApplicationView{

    private long applicantId;
    private long offerId;

}
