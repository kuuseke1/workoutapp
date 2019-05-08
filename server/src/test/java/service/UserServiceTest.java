package service;

import hello.model.User;
import hello.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @MockBean
    UserService service;

    @Test
    public void getAllUsersTest() {
        User user = new User();
        List<User> allUsers = Arrays.asList(user);
        given(service.getAllUsers()).willReturn(allUsers);
    }

    @Test
    public void deleteAllUsersTest() {
        User user = new User();
        service.addUser(user);
        service.deleteAll();
        given(service.getAllUsers()).willReturn(null);
    }

    @Test
    public void getUserByIdTest() {
        User user = new User();
        service.addUser(user);
        given(service.getUserById(user.getUserId())).willReturn(user);
    }

    @Test
    public void addUserTest() {
        User user = new User();
        service.addUser(user);
        given(service.getAllUsers()).willReturn(Arrays.asList(user));
    }

    @Test
    public void deleteUserByIdTest() {
        User user = new User();
        service.addUser(user);
        service.deleteUser(user.getUserId());
        given(service.getAllUsers()).willReturn(null);

    }

}
