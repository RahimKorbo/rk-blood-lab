package com.rk.bloodlab.serviceImpl;

import com.rk.bloodlab.dto.LabReportRequest;
import com.rk.bloodlab.service.ReportService;
import org.springframework.stereotype.Service;


@Service
public class ReportServiceImpl implements ReportService {
    @Override
    public void writeLines(String line, LabReportRequest request) {
        StringBuilder updated = null;
        String[] arr = line.split("#");
        for(String s:arr) {
            if(s.contains("LAB NAME: ______________________")) {
                 updated = new StringBuilder("LAB NAME:" + request.getPatientName());
            } else if(s.contains("DATE:__________________")) {
                 updated.append(" DATE:" + request.getReferredBy());
            }
        }
        System.out.println(updated);


    }
}
