package com.rk.bloodlab.serviceImpl;

import com.rk.bloodlab.service.LabUser;
import com.rk.bloodlab.user.Role;
import com.rk.bloodlab.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

}
