package hello.test.dao;

import hello.dao.WorkoutRepository;
import hello.model.Workout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkoutRepositoryTest {

    @Autowired
    WorkoutRepository workoutRepository;


    @Test
    public void deleteAllWorkoutsTest() throws Exception {
        Workout workout = new Workout();
        workoutRepository.save(workout);
        assert !workoutRepository.findAll().isEmpty();
        workoutRepository.deleteAll();
        assert workoutRepository.findAll().isEmpty();
    }

    @Test
    public void deleteSingleUserTest() throws Exception {
        Workout workout = new Workout();
        workoutRepository.save(workout);
        assert workoutRepository.findById((long) 1).isPresent();
        workoutRepository.delete(workout);
        assert !workoutRepository.findById((long) 1).isPresent();
    }
}
