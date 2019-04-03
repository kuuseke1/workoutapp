package tests.repository;

import hello.dao.UserRepository;
import hello.dao.WorkoutRepository;
import hello.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestComponent
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByUserNameTest() throws Exception {
        User user = new User("tim", null, null, true, null);
        userRepository.save(user);
        Optional<User> foundUser = userRepository.findByUsername("tim");
        assert foundUser.get().getUsername().equals(user.getUsername());
    }

}