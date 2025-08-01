package sergiomaselli.u6progetto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sergiomaselli.u6progetto.entities.Role;
import sergiomaselli.u6progetto.entities.User;
import sergiomaselli.u6progetto.services.UserService;

@RestController
@RequestMapping("/auth")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestParam String name,
                         @RequestParam String email,
                         @RequestParam String password,
                         @RequestParam Role role) {
        return userService.registerUser(name, email, password, role);
    }
}