package com.txa.workout_api.model;

import java.util.List;

public class Exercise {
    
    private Bodypart bodyPart;
    private String exerciseName;
    private List<Integer> sets;
    private String description;

    public Exercise() {}

    public Exercise(Bodypart bodyPart, String exerciseName, List<Integer> sets) {
        this(bodyPart, exerciseName, sets, ""); //Description is optional
    }

    public Exercise(Bodypart bodyPart, String exerciseName, List<Integer> sets, String description) {
        this.bodyPart = bodyPart;
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.description = description;
    }

    public Bodypart getBodyPart() {
        return this.bodyPart;
    }

    public void setBodyPart(Bodypart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getExerciseName() {
        return this.exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public List<Integer> getSets() {
        return this.sets;
    }

    public void setSets(List<Integer> sets) {
        this.sets = sets;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
            " bodyPart='" + getBodyPart() + "'" +
            ", exerciseName='" + getExerciseName() + "'" +
            ", sets='" + getSets() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }

}