package com.rk.bloodlab.controller;


import com.rk.bloodlab.auth.AuthenticationRequest;
import com.rk.bloodlab.auth.AuthenticationResponse;
import com.rk.bloodlab.auth.AuthenticationService;
import com.rk.bloodlab.auth.RegisterRequest;
import com.rk.bloodlab.dto.LabReportRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LabController {

    @Autowired
    private final AuthenticationService service;

    @PostMapping("/report")
    public ResponseEntity<?> register(
            @RequestBody LabReportRequest request
    ) {
        Map<String, String> body = new HashMap<>();
        body.put("message", request.toString());
        return new ResponseEntity<>(body, HttpStatus.OK);

    }





}
