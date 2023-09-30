package com.rk.bloodlab.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class ReportDetail {

    private double hemoglobin;

    private long leukocyte;

    private int neutrophils;

    private int lymphocyte;

    private int eosinophils;

    private int monocytes;

    private int basophils;

    private double platelet;

    private double rbc;

    private int hct;

    private double mcv;

    private double mch;

    private double mchc;

    private int mpv;

    private int sd;

    private int cv;

    private double lcr;

    private double pdw;

    private String abo;

    private String rh;

}
