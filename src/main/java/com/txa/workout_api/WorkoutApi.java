package com.txa.workout_api;

import java.util.ArrayList;
import java.util.List;

import com.txa.workout_api.Repository.WorkoutRepository;
import com.txa.workout_api.model.Bodypart;
import com.txa.workout_api.model.Exercise;
import com.txa.workout_api.model.Workout;
import com.txa.workout_api.model.WorkoutSplit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkoutApi implements CommandLineRunner {

	@Autowired
	private WorkoutRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(WorkoutApi.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
		repository.deleteAll();

		List<Integer> setsReps = new ArrayList<Integer>();
		setsReps.add(12);
		setsReps.add(12);
		setsReps.add(12);
		Exercise e1 = new Exercise(Bodypart.BACK, "Pull Ups", setsReps);
		List<Exercise> le1 = new ArrayList<Exercise>();
		le1.add(e1);
		Workout w1 = new Workout(WorkoutSplit.ARMS, le1);

		repository.save(w1);
	}

}
