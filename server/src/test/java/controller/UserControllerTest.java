package controller;

import hello.controller.UserController;
import hello.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
public class UserControllerTest {

    @MockBean
    private UserController userController;

    @Test
    public void isControllerInitialized() {
        assertThat(userController).isNotNull();
    }

    @Test
    public void getAllUsersTest() {
        User user = new User("tom", null, null, true, null);
        userController.addUser(user);
        given(userController.getAll()).willReturn(Arrays.asList(user));
    }

    @Test
    public void getUserByIdTest() {
        User user = new User("tom", null, null, true, null);
        userController.addUser(user);
        given(userController.getUserById(user.getId())).willReturn(user);
    }

    @Test
    public void addUserTest() {
        User user = new User("tom", null, null, true, null);
        userController.addUser(user);
        given(userController.getAll()).willReturn(Arrays.asList(user));
    }

    @Test
    public void deleteUserByIdTest() {
        User user = new User("tom", null, null, true, null);
        userController.addUser(user);
        userController.deleteUser(user.getId());
        given(userController.getAll()).willReturn(null);
    }

    @Test
    public void deleteAllUsersTest() {
        User user = new User("tom", null, null, true, null);
        User user2 = new User("tim", null, null, true, null);
        userController.addUser(user);
        userController.addUser(user2);
        userController.deleteAll();
        given(userController.getAll()).willReturn(null);


    }
}
