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
        pdfUtil.createLabPdf(null);
    }
}
