package com.txa.workout_api.controller;

import java.util.List;

import javax.validation.Valid;

import com.mongodb.lang.NonNull;
import com.txa.workout_api.Repository.WorkoutRepository;
import com.txa.workout_api.model.Workout;
import com.txa.workout_api.model.WorkoutSplit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {
    
    private WorkoutRepository repository;

    @Autowired
    public WorkoutController( WorkoutRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/v1/all")
    public List<Workout> getAllWorkouts() {
        return repository.findAll();
    }

    @GetMapping("/api/v1/{splitType}")
    public Workout getWorkoutBySplit(@PathVariable("splitType") String splitType) {
        WorkoutSplit eWorkoutSplit = WorkoutSplit.valueOf(splitType.toUpperCase());
        Workout workout = repository.findBySplitType(eWorkoutSplit);
        return workout;
    }

    @PostMapping("/api/v1/")
    public ResponseEntity<String> addWorkout(@Valid @NonNull @RequestBody Workout newWorkout) {
        try {
            repository.save(newWorkout);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>("New workout added!", HttpStatus.OK);
    }

    @PutMapping("/api/v1/{id}")
    public ResponseEntity<String> updateWorkoutById(@NonNull @PathVariable("id") String id, @Valid @NonNull @RequestBody Workout updatedWorkout) {
        try {
            if (repository.existsById(id))
            {
                repository.save(updatedWorkout);
            }
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Workout updated!\n", HttpStatus.OK);
    }

    @DeleteMapping("/api/v1/{id}")
    public String deleteWorkout(@NonNull @PathVariable("id") String id) {
        repository.deleteById(id);
        return id;
    }
}