package controllers;

import classes.User;
import classes.RoleType;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
        User newUser = userService.createUser(user.getLogin(), user.getPassword(), RoleType.ROLE_USER);
        return ResponseEntity.ok("User " + newUser.getLogin() + " registered successfully!");
    }
}
