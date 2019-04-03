package hello.service;

import hello.dao.UserRepository;
import hello.model.User;
import hello.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

    public void addWorkout(User user, Workout workout) {
        List<Workout> workouts = user.getWorkouts();
        workouts.add(workout);
        user.setWorkouts(workouts);
    }

}