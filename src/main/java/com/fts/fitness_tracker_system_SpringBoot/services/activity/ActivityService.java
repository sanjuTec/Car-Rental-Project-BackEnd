package com.fts.fitness_tracker_system_SpringBoot.services.activity;

import com.fts.fitness_tracker_system_SpringBoot.dto.ActivityDTO;

public interface ActivityService {

    ActivityDTO postActivity(ActivityDTO activityDTO);
}
