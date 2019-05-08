package controller;

import hello.controller.WorkoutController;
import hello.model.Exercise;
import hello.model.Workout;
import org.hibernate.jdbc.Work;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
public class WorkoutControllerTest {

    @MockBean
    private WorkoutController controller;

    @Test
    public void isControllerInitialized() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void getAllWorkoutsTest() {
        Workout workout = new Workout();
        controller.addWorkout(workout);
        given(controller.getAll()).willReturn(Arrays.asList(workout));
    }

    @Test
    public void getWorkoutByIdTest() {
        Workout workout = new Workout();
        controller.addWorkout(workout);
        given(controller.getWorkoutById(workout.getId())).willReturn(workout);
    }

    @Test
    public void addWorkoutTest() {
        Workout workout = new Workout();
        controller.addWorkout(workout);
        assertThat(controller.getAll()).isNotNull();
    }

    @Test
    public void updateWorkoutTest() {
        Workout workout = new Workout((long) 1, null, null);
        controller.addWorkout(workout);
        Workout workout_updated = new Workout((long) 2, null, (long) 10);
        controller.updateWorkout((long) 1, workout_updated);
        given(controller.getWorkoutById((long) 1)).willReturn(workout_updated);
    }

    @Test
    public void deleteWorkoutTest() {
        Workout workout = new Workout();
        controller.addWorkout(workout);
        given(controller.getWorkoutById(workout.getId())).willReturn(null);
    }

    @Test
    public void deleteAllWorkoutsTest() {
        Workout workout = new Workout();
        controller.addWorkout(workout);
        controller.deleteAll();
        given(controller.getAll()).willReturn(null);
    }
}
