package com.fts.fitness_tracker_system_SpringBoot.repository;

import com.fts.fitness_tracker_system_SpringBoot.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
