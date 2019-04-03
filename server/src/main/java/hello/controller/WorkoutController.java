package hello.controller;

import hello.model.Workout;
import hello.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @GetMapping("/workouts")
    @ResponseBody
    public List<Workout> getAll() {

        workoutService.generateWorkouts();
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/workouts/{workoutId}")
    @ResponseBody
    public Workout getWorkoutById(@PathVariable("workoutId") Long workoutId) {
        return workoutService.getWorkoutById(workoutId);
    }

    @PostMapping("/workouts")
    @ResponseBody
    public Workout addWorkout(@RequestBody Workout workout) {
        workoutService.addWorkout(workout);
        return workout;
    }

    @PutMapping("/workouts/{workoutId}")
    public void updateUser(@PathVariable Long workoutId, @RequestBody Workout workout) {
        Workout toUpdateWorkout = workoutService.getWorkoutById(workoutId);
        toUpdateWorkout.setExercises(workout.getExercises());
        toUpdateWorkout.setTimestamp(workout.getTimestamp());
        workoutService.addWorkout(toUpdateWorkout);
    }

    @DeleteMapping("/workouts/{workoutId}")
    public void deleteWorkout(@PathVariable("workoutId") Long workoutId) {
        workoutService.deleteWorkout(workoutId);
    }

    @DeleteMapping("/workouts")
    public void deleteAll() {
        workoutService.deleteAll();
    }
}
