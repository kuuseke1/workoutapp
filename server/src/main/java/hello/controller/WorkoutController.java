package hello.controller;

import hello.model.Workout;
import hello.service.WorkoutService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = {"/workouts"})
public class WorkoutController {

    @Autowired
    WorkoutService workoutService;

    @GetMapping("")
    @ResponseBody
    public List<Workout> getAll() {

        workoutService.generateWorkouts();
        return workoutService.getAllWorkouts();
    }

    @GetMapping("{workoutId}")
    @ResponseBody
    public Workout getWorkoutById(@PathVariable("workoutId") Long workoutId) {
        return workoutService.getWorkoutById(workoutId);
    }

    @PostMapping("")
    @ResponseBody
    public Workout addWorkout(@RequestBody Workout workout) {
        workoutService.addWorkout(workout);
        System.out.println(workoutService.getAllWorkouts());
        return workout;
    }

    @PutMapping("{workoutId}")
    @ResponseBody
    public void updateUser(@PathVariable Long workoutId, @RequestBody Workout workout) {
        Workout toUpdateWorkout = workoutService.getWorkoutById(workoutId);
        toUpdateWorkout.setExercises(workout.getExercises());
        toUpdateWorkout.setTimestamp(workout.getTimestamp());
        workoutService.addWorkout(toUpdateWorkout);
    }

    @DeleteMapping("{workoutId}")
    @ResponseBody
    public void deleteWorkout(@PathVariable("workoutId") Long workoutId) {
        workoutService.deleteWorkout(workoutId);
    }

    @DeleteMapping("")
    @ResponseBody
    public void deleteAll() {
        workoutService.deleteAll();
    }
}
