package com.txa.workout_api.Repository;

import com.txa.workout_api.model.Workout;
import com.txa.workout_api.model.WorkoutSplit;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkoutRepository extends MongoRepository<Workout, String> {
    public Workout findBySplitType(WorkoutSplit splitType);
    public void deleteById(String id);
}