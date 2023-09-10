package com.rk.bloodlab.serviceImpl;

import com.rk.bloodlab.dto.LabReportRequest;
import com.rk.bloodlab.service.LabUser;
import com.rk.bloodlab.user.Role;
import com.rk.bloodlab.user.User;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LabUserServiceImpl implements LabUser {


    @Value("${application.userdata.user}")
    private String user;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        BCryptPasswordEncoder encoder = passwordEncoder1();

        return  new User(1, "Admin",
                "Admin", "admin@mail.com", encoder.encode("password"), Role.ADMIN);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder1() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void loadPDFAndWritePatientDetails(LabReportRequest request, MultipartFile pdfFile) {
        String text;

        try (final PDDocument document = PDDocument.load(pdfFile.getInputStream())) {
            final PDFTextStripper pdfStripper = new PDFTextStripper();
            text = pdfStripper.getText(document);
        } catch (final Exception ex) {
            text = "Error parsing PDF";
        }

        System.out.println("FROM FILE---\n"+text);



    }

    @Override
    public void writeLines(String lines) {
        String[] arr = lines.split("#");
        System.out.println(arr);
    }
}
