package com.crs.car_rental_system_SpringBoot.repository;

import com.crs.car_rental_system_SpringBoot.entity.User;
import com.crs.car_rental_system_SpringBoot.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findFirstByEmail(String username);

    Optional<User> findByUserRole(UserRole userRole);
}
