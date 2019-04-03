package hello.controller;

import hello.dao.UserRepository;
import hello.model.User;
import hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @PostMapping("registration")
    @ResponseBody
    public void registration(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("login")
    @ResponseBody
    public String login(String error, String logout) {
        if (error != null)
            return "Invalid credentials";

        if (logout != null)
            return "Successful logout";

        return "login";
    }

    @GetMapping({"", "welcome"})
    @ResponseBody
    public String welcome() {
        return "welcome";
    }
}