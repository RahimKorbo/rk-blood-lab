package com.rk.bloodlab.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
public class LabReportRequest {

    private String patientName;
    private int patientAge;
    private String patientSex;
    private String referredBy;
    private String reportCreatedBy;
}
