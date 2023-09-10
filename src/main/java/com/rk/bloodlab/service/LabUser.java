package com.rk.bloodlab.service;

import com.rk.bloodlab.dto.LabReportRequest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface LabUser extends UserDetailsService {
    void loadPDFAndWritePatientDetails(LabReportRequest request, MultipartFile pdfFile);

    void writeLines(String lines);
}
