package com.rk.bloodlab.dto;

import lombok.*;

@Data
@ToString
@Builder
public class LabReportRequest {

    private String patientName;
    private int age;
    private String gender;
    private String refBy;
    private long regOn;
    private long uhid;
    private String investigation;
    private String registeredOn;
    private String collectedOn;
    private String receivedOn;
    private String reportedOn;
    private ReportDetail details;

    public LabReportRequest(String patientName, int age, String gender, String refBy, long regOn, long uhid, String investigation, String registeredOn, String collectedOn, String receivedOn, String reportedOn, ReportDetail details) {
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.refBy = refBy;
        this.regOn = regOn;
        this.uhid = uhid;
        this.investigation = investigation;
        this.registeredOn = registeredOn;
        this.collectedOn = collectedOn;
        this.receivedOn = receivedOn;
        this.reportedOn = reportedOn;
        this.details = details;
    }
}