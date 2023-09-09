package com.rk.bloodlab.service;

import com.rk.bloodlab.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface LabUser extends UserDetailsService {
}
