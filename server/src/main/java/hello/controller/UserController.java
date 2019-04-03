package hello.controller;

import hello.model.User;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired private UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    @ResponseBody
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/users/{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody User user) {
        User toUpdateUser = userService.getUserById(userId);
        toUpdateUser.setUserName(user.getUserName());
        toUpdateUser.setUserHeight(user.getUserHeight());
        toUpdateUser.setUserWeight(user.getUserWeight());
        userService.addUser(toUpdateUser);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteWorkout(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    @DeleteMapping("/users")
    public void deleteAll() {
        userService.deleteAll();
    }

}
