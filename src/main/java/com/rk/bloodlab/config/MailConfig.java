package com.rk.bloodlab.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("your-smtp-host");
        mailSender.setPort(587); // Replace with your SMTP port
        mailSender.setUsername("your-email@example.com");
        mailSender.setPassword("your-email-password");

        // Configure additional properties like TLS, SSL, etc., if needed

        return mailSender;
    }
}
