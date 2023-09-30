package com.rk.bloodlab.serviceImpl;

import com.itextpdf.text.DocumentException;
import com.rk.bloodlab.dto.LabReportRequest;
import com.rk.bloodlab.service.ReportService;
import com.rk.bloodlab.utility.PdfUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    PdfUtil pdfUtil;


    @Override
    public void writeLines(String line, LabReportRequest request) {
        StringBuilder updated = null;
        String[] arr = line.split("#");
        for(String s:arr) {
            if(s.contains("LAB NAME: ______________________")) {
                 updated = new StringBuilder("LAB NAME:" + request.getPatientName());
            } else if(s.contains("DATE:__________________")) {
                 updated.append(" DATE:" + request.getRefBy());
            }
        }
        System.out.println(updated);


    }

    @Override
    public void processReport(LabReportRequest request) throws DocumentException, IOException {
        pdfUtil.createBloodReport(request);
    }
}
