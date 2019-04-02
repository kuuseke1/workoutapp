package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WorkoutController {

    @Autowired WorkoutRepository repository;

    @GetMapping("/workouts")
    @ResponseBody
    public List<Workout> getAll() {
        return repository.findAll();
    }

    @GetMapping("/workouts/{workoutId}")
    @ResponseBody
    public Workout getWorkoutById(@PathVariable("workoutId") Long workoutId) {
        return repository.getOne(workoutId);
    }

    @PostMapping("/workouts")
    @ResponseBody
    public Workout addWorkout(@RequestBody Workout workout) {
        repository.save(workout);
        return workout;
    }

    @DeleteMapping("/workouts/{workoutId}")
    public void deleteWorkout(@PathVariable("workoutId") Long workoutId) {
        repository.deleteById(workoutId);
    }

    @DeleteMapping("/workouts")
    public void deleteAll() {
        repository.deleteAll();
    }
}
