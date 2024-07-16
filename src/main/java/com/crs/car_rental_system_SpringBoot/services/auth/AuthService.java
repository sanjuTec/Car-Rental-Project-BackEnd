package com.crs.car_rental_system_SpringBoot.services.auth;

import com.crs.car_rental_system_SpringBoot.dto.SignupRequest;
import com.crs.car_rental_system_SpringBoot.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {

    UserDTO signupUser(SignupRequest signUpRequest);

    boolean hasUserWithEmail(String email);
}
