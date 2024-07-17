package com.fts.fitness_tracker_system_SpringBoot.controller;

import com.fts.fitness_tracker_system_SpringBoot.dto.ActivityDTO;
import com.fts.fitness_tracker_system_SpringBoot.services.activity.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping(value = "/activity")
    public ResponseEntity<?> postActivity(@RequestBody ActivityDTO activityDTO){
        ActivityDTO createdActivity = activityService.postActivity(activityDTO);
        if(createdActivity != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdActivity);
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }
}
