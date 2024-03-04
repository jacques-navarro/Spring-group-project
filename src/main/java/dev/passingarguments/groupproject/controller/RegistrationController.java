package dev.passingarguments.groupproject.controller;

import dev.passingarguments.groupproject.entity.LoginPage;
import dev.passingarguments.groupproject.entity.User;
import dev.passingarguments.groupproject.repo.LoginInterface;
import dev.passingarguments.groupproject.repo.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Controller
public class RegistrationController {

    private
    UserInterface userInterface;

    private LoginInterface loginInterface;

    public RegistrationController() {
    }

    ;

    @Autowired
    public RegistrationController(UserInterface userInterface, LoginInterface loginInterface) {
        this.userInterface = userInterface;
        this.loginInterface = loginInterface;
    }

    @GetMapping("/home")
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

        /*Optional<User> o = userInterface.findByUserName(userName);

        if (o.isPresent()) {
            User user = o.get();

            if (user.getPassword().equals(password)) {
                return "logged-in";
            }
        }*/

        List<User> users = userInterface.findAll();

        User user = users.stream().filter(u -> u.getUserName().equalsIgnoreCase(userName)).findAny().orElse(null);

            if (user != null && user.getPassword().equals(password)) {
                LoginPage loginPage = new LoginPage();
                loginPage.setEmail(user.getEmail());
                loginPage.setLoginDate(Date.valueOf(LocalDate.now()));
                loginPage.setLoginTime(Time.valueOf(LocalTime.now()));
                loginPage.setUser(user);

                loginInterface.save(loginPage);

                return "logged-in";
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
    public String registerUser(@RequestParam("username") String username, @RequestParam("birthdate") String birthdate,
                               @RequestParam("password") String password, @RequestParam("email") String email,
                               Model model) {

        User user = new User();
        user.setUserName(username);
        user.setBirthdate(birthdate);
        user.setEmail(email);
        user.setPassword(password);

        userInterface.save(user);

        return "log-user-in";
    }
}