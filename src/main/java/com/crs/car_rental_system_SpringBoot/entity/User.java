package com.crs.car_rental_system_SpringBoot.entity;

import com.crs.car_rental_system_SpringBoot.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  String email;

    private String password;

    private UserRole userRole;

}
