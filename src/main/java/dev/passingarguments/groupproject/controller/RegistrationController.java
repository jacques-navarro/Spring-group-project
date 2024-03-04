package dev.passingarguments.groupproject.controller;

import dev.passingarguments.groupproject.entity.User;
import dev.passingarguments.groupproject.repo.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class RegistrationController {

    private
    UserInterface userInterface;

    public RegistrationController() {
    }

    ;

    @Autowired
    public RegistrationController(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @GetMapping("/")
    public String getHome() {
        return "home";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "log-user-in";
    }


    @PostMapping("/log-user-in")
    public String logUserIn(@RequestParam("username") String userName,
                            @RequestParam("password") String password,
                            Model model) {

        Optional<User> o = userInterface.findByUserName(userName);

        if (o.isPresent()) {
            User user = o.get();

            if (user.getPassword().equals(password)) {
                return "logged-in";
            }
        }
        return "log-user-in";
    }

    @GetMapping("/logged-in")
    public String loggedIn() {
        return "content";
    }

    @GetMapping("/register")
    public String register() {
        return "register-user";
    }

    @PostMapping("/create-user")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);

        userInterface.save(user);

        return "log-user-in";
    }
}