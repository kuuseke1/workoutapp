package service;

import hello.model.Workout;
import hello.service.WorkoutService;
import org.hibernate.jdbc.Work;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class WorkoutServiceTest {

    @MockBean
    private WorkoutService service;

    @Test
    public void getAllWorkoutTest() throws Exception {
        Workout workout = new Workout();
        List<Workout> allWorkouts = Arrays.asList(workout);
        given(service.getAllWorkouts()).willReturn(allWorkouts);
    }

    @Test
    public void deleteAllWorkoutTest() {
        Workout workout = new Workout();
        service.addWorkout(workout);
        service.deleteAll();
        given(service.getAllWorkouts()).willReturn(null);
    }

    @Test
    public void getWorkoutByIdTest() {
        Workout workout = new Workout();
        service.addWorkout(workout);
        given(service.getWorkoutById(workout.getId())).willReturn(workout);
    }

    @Test
    public void addWorkoutTest() {
        Workout workout = new Workout();
        service.addWorkout(workout);
        given(service.getAllWorkouts()).willReturn(Arrays.asList(workout));
    }

    @Test
    public void deleteWorkoutByIdTest() {
        Workout workout = new Workout();
        service.addWorkout(workout);
        service.deleteWorkout(workout.getId());
        given(service.getAllWorkouts()).willReturn(null);

    }
}
