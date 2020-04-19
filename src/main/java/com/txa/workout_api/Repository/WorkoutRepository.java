package com.txa.workout_api.Repository;

import java.util.List;

import com.txa.workout_api.model.Workout;
import com.txa.workout_api.model.WorkoutSplit;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkoutRepository extends MongoRepository<Workout, String> {
    public List<Workout> findBySplitType(WorkoutSplit splitType);
}