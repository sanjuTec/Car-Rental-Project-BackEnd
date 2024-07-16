package com.crs.car_rental_system_SpringBoot.dto;

import com.crs.car_rental_system_SpringBoot.enums.UserRole;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private  String email;

    private UserRole userRole;
}
