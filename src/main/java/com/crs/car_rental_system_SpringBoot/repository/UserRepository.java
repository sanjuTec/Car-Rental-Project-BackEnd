package com.crs.car_rental_system_SpringBoot.repository;

import com.crs.car_rental_system_SpringBoot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
