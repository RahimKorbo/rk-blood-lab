package com.rk.bloodlab.service;

import com.itextpdf.text.DocumentException;
import com.rk.bloodlab.dto.LabReportRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ReportService {

    void writeLines(String line, LabReportRequest request);

    void processReport(LabReportRequest request) throws DocumentException, IOException;
}
