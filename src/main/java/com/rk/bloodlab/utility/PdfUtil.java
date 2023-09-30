package com.rk.bloodlab.utility;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfAcroForm;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.rk.bloodlab.dto.LabReportRequest;
import com.rk.bloodlab.dto.ReportDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class PdfUtil {

    @Value("${range.hemo_min}")
    private long hemo_min;

    @Value("${range.hemo_max}")
    private long hemo_max;

    @Value("${range.leu_min}")
    private long leu_min;

    @Value("${range.leu_max}")
    private long leu_max;

    @Value("${range.mch_min}")
    private long mch_min;

    @Value("${range.mch_max}")
    private long mch_max;

    @Value("${range.mchc_min}")
    private double mchc_min;

    @Value("${range.mchc_max}")
    private double mchc_max;

    @Value("${range.pdw_min}")
    private double pdw_min;

    @Value("${range.pdw_max}")
    private double pdw_max = 15.2;

    @Value("${footer.dr_name}")
    private String dr_name;

    @Value("${footer.dr_degree}")
    private String dr_degree;

    @Value("${footer.tech_name}")
    private String tech_name;

    @Value("${footer.tech_pos}")
    private String tech_pos;

    public void createLabPdf(LabReportRequest request) throws IOException, DocumentException {

        PdfReader reader = new PdfReader(AppConstants.LAB_TEMPLATE);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("CreatedPdf.pdf"));
        AcroFields form = stamper.getAcroFields();
        form.setField(AppConstants.LAB_NAME, "Test Lab");
        form.setField(AppConstants.DATE, "12/09/2023");
        form.setField(AppConstants.PATIENT_NAME, "Rahim");
        form.setField(AppConstants.GENDER, "Male");
        form.setField(AppConstants.REFERRED_BY, "Prath");
        form.setField(AppConstants.AGE, "26");
        stamper.close();
    }

    public static void main(String[] args) throws DocumentException, IOException {
        PdfUtil pdfUtil = new PdfUtil();
        pdfUtil.createBloodReport(LabReportRequest.builder().patientName("Rahim").age(30).details(ReportDetail.builder().hemoglobin(20).build()).build());
    }

    public void createBloodReport(LabReportRequest request) throws IOException, DocumentException {

        ReportDetail detail = request.getDetails();

        PdfReader reader = new PdfReader(AppConstants.NEW_LAB_TEMPLATE);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(request.getPatientName()+"_CreatedPdfNew.pdf"));
        AcroFields form = stamper.getAcroFields();

        form.setField(AppConstants.PATIENT_NAME, request.getPatientName());
        form.setField(AppConstants.AGE, request.getAge() + AppConstants.SEPARATOR + request.getGender());
        form.setField(AppConstants.REFERRED_BY, request.getRefBy());
        form.setField(AppConstants.REG_NO, request.getRegOn() + AppConstants.SEPARATOR + request.getUhid());
        form.setField(AppConstants.INVESTIGATION, request.getInvestigation());
        form.setField(AppConstants.REG_ON, request.getRegisteredOn());
        form.setField(AppConstants.COLL_ON, request.getCollectedOn());
        form.setField(AppConstants.REC_ON, request.getReceivedOn());
        form.setField(AppConstants.REPO_ON, request.getReportedOn());

        form.setField(AppConstants.HEMO, String.valueOf(detail.getHemoglobin()));
        form.setField(AppConstants.HEMO_INIT, getInitValue(detail.getHemoglobin(), hemo_min, hemo_max));

        form.setField(AppConstants.LEU, String.valueOf(detail.getLeukocyte()));
        form.setField(AppConstants.LEU_INIT, getInitValue(detail.getLeukocyte(), leu_min, leu_max));

        form.setField(AppConstants.NEU, String.valueOf(detail.getNeutrophils()));
        form.setField(AppConstants.LYMP, String.valueOf(detail.getLymphocyte()));
        form.setField(AppConstants.EOSIN, String.valueOf(detail.getEosinophils()));
        form.setField(AppConstants.MONO, String.valueOf(detail.getMonocytes()));
        form.setField(AppConstants.BASO, String.valueOf(detail.getBasophils()));

        form.setField(AppConstants.PLATE, String.valueOf(detail.getPlatelet()));
        form.setField(AppConstants.RBC, String.valueOf(detail.getRbc()));
        form.setField(AppConstants.HCT, String.valueOf(detail.getHct()));
        form.setField(AppConstants.MCV, String.valueOf(detail.getMcv()));

        form.setField(AppConstants.MCH, String.valueOf(detail.getMch()));
        form.setField(AppConstants.MCH_INIT, getInitValue(detail.getMch(), mch_min, mch_max));
        form.setField(AppConstants.MCHC, String.valueOf(detail.getMchc()));
        form.setField(AppConstants.MCHC_INIT, getInitValue(detail.getMchc(), mchc_min, mchc_max));

        form.setField(AppConstants.MPV, String.valueOf(detail.getMpv()));
        form.setField(AppConstants.SD, String.valueOf(detail.getSd()));
        form.setField(AppConstants.CV, String.valueOf(detail.getCv()));
        form.setField(AppConstants.LCR, String.valueOf(detail.getLcr()));

        form.setField(AppConstants.PDW, String.valueOf(detail.getPdw()));
        form.setField(AppConstants.PDW_INIT, getInitValue(detail.getPdw(), pdw_min, pdw_max));

        form.setField(AppConstants.ABO, detail.getAbo());
        form.setField(AppConstants.RH, detail.getRh());

        form.setField(AppConstants.DR_NAME, dr_name);
        form.setField(AppConstants.DR_DEGREE, dr_degree);
        form.setField(AppConstants.TECH_NAME, tech_name);
        form.setField(AppConstants.TECH_POS, tech_pos);

        stamper.close();
    }

    private String getInitValue(double value, double min, double max) {

        return value < min
                ? "L"
                : value > max
                ? "H"
                : "";

    }
}