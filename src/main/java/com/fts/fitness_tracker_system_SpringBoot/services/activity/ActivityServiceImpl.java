package com.fts.fitness_tracker_system_SpringBoot.services.activity;

import com.fts.fitness_tracker_system_SpringBoot.dto.ActivityDTO;
import com.fts.fitness_tracker_system_SpringBoot.entity.Activity;
import com.fts.fitness_tracker_system_SpringBoot.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService{

    private  final ActivityRepository activityRepository;


    @Override
    public ActivityDTO postActivity(ActivityDTO activityDTO) {
        Activity activity = new Activity();
        activity.setDate(activityDTO.getDate());
        activity.setDistance(activityDTO.getDistance());
        activity.setSteps(activityDTO.getSteps());
        activity.setCaloriesBurned(activityDTO.getCaloriesBurned());
        return activityRepository.save(activity).getActivityDTO();
    }
}
