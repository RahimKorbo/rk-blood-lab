package com.rk.bloodlab.service;

import com.rk.bloodlab.dto.LabReportRequest;
import org.springframework.stereotype.Service;

@Service
public interface ReportService {

    void writeLines(String line, LabReportRequest request);
}
