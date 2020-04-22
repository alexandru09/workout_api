package com.txa.workout_api.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "workouts")
public class Workout {

    @Id
    private String id;

    private WorkoutSplit splitType;
    private List<Exercise> exercises;

    public Workout() {}

    public Workout(WorkoutSplit splitType, List<Exercise> exercises) {
        this.splitType = splitType;
        this.exercises = exercises;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WorkoutSplit getSplitType() {
        return this.splitType;
    }

    public void setSplitType(WorkoutSplit splitType) {
        this.splitType = splitType;
    }

    public List<Exercise> getExercises() {
        return this.exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", splitType='" + getSplitType() + "'" +
            ", exercises='" + getExercises() + "'" +
            "}";
    }

}