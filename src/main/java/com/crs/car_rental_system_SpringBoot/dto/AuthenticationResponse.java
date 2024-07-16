package com.crs.car_rental_system_SpringBoot.dto;

import com.crs.car_rental_system_SpringBoot.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private Long userId;
    private UserRole userRole;
}
