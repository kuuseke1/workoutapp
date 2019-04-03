package hello.service;

import hello.dao.WorkoutRepository;
import hello.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    EntityManager em;

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();

    }

    public Workout getWorkoutById(Long workoutId) {
        return workoutRepository.findById(workoutId).orElseThrow(() -> new EntityNotFoundException(workoutId.toString()));
    }

    public Workout addWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public void deleteWorkout(Long workoutId) {
        workoutRepository.deleteById(workoutId);
    }

    public void deleteAll() {
        workoutRepository.deleteAll();
    }

    public void generateWorkouts() {

    }

}
