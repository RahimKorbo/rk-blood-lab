package com.rk.bloodlab.utility;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfAcroForm;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.rk.bloodlab.dto.LabReportRequest;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfUtil {


    public void createLabPdf(LabReportRequest request) throws IOException, DocumentException {

        PdfReader reader = new PdfReader(AppConstants.LAB_TEMPLATE);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("CreatedPdf.pdf"));
        AcroFields form = stamper.getAcroFields();
        form.setField(AppConstants.LAB_NAME , "Test Lab");
        form.setField(AppConstants.DATE , "12/09/2023");
        form.setField(AppConstants.PATIENT_NAME , "Rahim");
        form.setField(AppConstants.GENDER , "Male");
        form.setField(AppConstants.REFERRED_BY , "Prath");
        form.setField(AppConstants.AGE , "26");
        stamper.close();
    }


    public static void main(String[] args) throws DocumentException, IOException {
        PdfUtil pdfUtil = new PdfUtil();
        pdfUtil.createLabPdfNew(null);
    }

    public void createLabPdfNew(LabReportRequest request) throws IOException, DocumentException {

        PdfReader reader = new PdfReader(AppConstants.NEW_LAB_TEMPLATE);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("CreatedPdfNew.pdf"));
        AcroFields form = stamper.getAcroFields();
        form.setField(AppConstants.PATIENT_NAME , "THOMAS JAMES");
        form.setField(AppConstants.AGE , "26 / M");
        form.setField(AppConstants.REFERRED_BY , "Rahim");
        form.setField(AppConstants.REG_NO , "900999");
        form.setField(AppConstants.INVESTIGATION , "Blood");
        form.setField(AppConstants.REG_ON , "17/09/2023");
        form.setField(AppConstants.COLL_ON,"17/09/2023");
        form.setField(AppConstants.REC_ON,"17/09/2023");
        form.setField(AppConstants.REPO_ON, "17/09/2023");

        form.setField(AppConstants.HEMO, "              10");
        form.setField(AppConstants.LEU, "20");
        form.setField(AppConstants.NEU, "10");
        form.setField(AppConstants.LYMP, "30");
        form.setField(AppConstants.EOSIN, "4");
        form.setField(AppConstants.MONO, "2");
        form.setField(AppConstants.BASO, "0.2");

        form.setField(AppConstants.PLATE, "3.2");
        form.setField(AppConstants.RBC, "4.0");
        form.setField(AppConstants.HCT,"38");
        form.setField(AppConstants.MCV, "84");
        form.setField(AppConstants.MCH, "28");
        form.setField(AppConstants.MCHC, "34");
        form.setField(AppConstants.MPV, "7");
        form.setField(AppConstants.SD, "40");
        form.setField(AppConstants.CV, "23");
        form.setField(AppConstants.LCR, "32");
        form.setField(AppConstants.PDW, "10");

        form.setField(AppConstants.ABO, "2.2");
        form.setField(AppConstants.RH, "32");

        form.setField(AppConstants.DR_NAME, "Mr Shiraj Mamujee");
        form.setField(AppConstants.DR_DEGREE, "MBcC");
        form.setField(AppConstants.TECH_NAME, "Mr Rakehs");
        form.setField(AppConstants.TECH_POS, "DMLT");


        stamper.close();
    }

}
