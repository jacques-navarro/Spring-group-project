package dev.passingarguments.groupproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

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

        return "logged-in";
    }

    @GetMapping("/logged-in")
    public String loggedIn() {
        return "content";
    }

    @GetMapping("/register")
    public String register() {
        return "register-user";
    }

    @GetMapping("/register-user")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {

        return "login";
    }
}