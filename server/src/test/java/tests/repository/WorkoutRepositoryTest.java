package tests.repository;

import hello.dao.WorkoutRepository;
import hello.model.Workout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WorkoutRepositoryTest {
    @Autowired
    WorkoutRepository workoutRepository;

    @Test
    public void findByIdTest() throws Exception {
        Workout workout = new Workout();
        workoutRepository.save(workout);
        Optional<Workout> found = workoutRepository.findById(workout.getId());
        assert found.get().getId().equals(workout.getId());
    }
}
