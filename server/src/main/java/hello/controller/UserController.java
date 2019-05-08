package hello.controller;

import hello.dao.UserRepository;
import hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/users"})
public class UserController {

    @Autowired private UserRepository userRepository;

    @GetMapping("")
    @ResponseBody
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("{userId}")
    @ResponseBody
    public User getUserById(@PathVariable("userId") Long userId) {
        return userRepository.getOne(userId);
    }

    @PostMapping("")
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

//    @PutMapping("{userId}")
//    public void updateUser(@PathVariable Long userId, @RequestBody User user) {
//        Optional<User> toUpdateUser = userRepository.findById(user.getUserId());
//        if (toUpdateUser.isPresent()) {
//            toUpdateUser.get().setUsername(user.getUsername());
//            toUpdateUser.get().setUserWeight(user.getUserWeight());
//            toUpdateUser.get().setUserHeight(user.getUserHeight());
//            userRepository.save(toUpdateUser.get());
//        }
//    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userRepository.deleteById(userId);
    }

    @DeleteMapping("")
    public void deleteAll() {
        userRepository.deleteAll();
    }

}
