package hello.test.dao;

import hello.dao.UserRepository;
import hello.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void findByUserNameTest() throws Exception {
        User user = new User("tim", null, null, true, null);
        userRepository.save(user);
        assert userRepository.findByUsername("tim").get().getUsername().equals(user.getUsername());
    }

    @Test
    public void addUserTest() throws Exception {
        User user = new User("tim", null, null, true, null);
        userRepository.save(user);
        assert userRepository.findByUsername("tim").isPresent();
    }

    @Test
    public void deleteAllUserTest() throws Exception {
        User user = new User("tim", null, null, true, null);
        userRepository.save(user);
        assert !userRepository.findAll().isEmpty();
        userRepository.deleteAll();
        assert userRepository.findAll().isEmpty();
    }

    @Test
    public void deleteSingleUserTest() throws Exception {
        User user = new User("tim", null, null, true, null);
        userRepository.save(user);
        assert userRepository.findByUsername("tim").isPresent();
        userRepository.delete(user);
        assert !userRepository.findByUsername("tim").isPresent();
    }
}