package com.example.birdscout.controller;

import com.example.birdscout.entity.User;
import com.example.birdscout.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    // Simple registration endpoint
    @PostMapping("/register")
    public User registerUser(@RequestBody User user,
                             @RequestParam(defaultValue = "ROLE_USER") String roleName) {
        return userService.createUser(user, roleName);
    }
}
