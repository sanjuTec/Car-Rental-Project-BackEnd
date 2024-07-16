package com.crs.car_rental_system_SpringBoot.dto;

import lombok.Data;

@Data
public class SignupRequest {

    private String name;

    private  String email;

    private String password;

}
