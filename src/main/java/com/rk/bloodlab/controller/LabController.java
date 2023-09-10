package com.rk.bloodlab.controller;

import com.rk.bloodlab.auth.AuthenticationService;
import com.rk.bloodlab.dto.LabReportRequest;
import com.rk.bloodlab.service.LabUser;
import com.rk.bloodlab.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LabController {

    @Autowired
    private final AuthenticationService service;


    @Autowired
    private ReportService labUser;

    @PostMapping("/report")
    public ResponseEntity<?> register(
            @RequestBody LabReportRequest request
    ) {


        Map<String, String> body = new HashMap<>();
        body.put("message", request.toString());
        return new ResponseEntity<>(body, HttpStatus.OK);

    }


    @PostMapping("/test")
    public void classify(@RequestBody LabReportRequest request) throws IOException {
        try (PDDocument document = PDDocument.load(new File(Objects.requireNonNull(getClass().getResource("/data/LABTEMPLATE.pdf")).getFile()))) {
            document.getClass();
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                String pdfFileInText = tStripper.getText(document);
                //System.out.println("Text:" + st);
                // split by whitespace
                String[] lines = pdfFileInText.split("\\r?\\n");

                for (String line : lines) {
                    labUser.writeLines(line, request);
                //    System.out.println(line);
                }
            }
        }
    }




}
