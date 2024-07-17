package com.fts.fitness_tracker_system_SpringBoot.entity;

import com.fts.fitness_tracker_system_SpringBoot.dto.ActivityDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private  int steps;
    private double distance;
    private int caloriesBurned;

   public ActivityDTO getActivityDTO(){
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setId(id);
        activityDTO.setDate(date);
        activityDTO.setSteps(steps);
        activityDTO.setDistance(distance);
        activityDTO.setCaloriesBurned(caloriesBurned);
        return activityDTO;
    }
}
