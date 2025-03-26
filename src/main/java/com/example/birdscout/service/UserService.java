package com.example.birdscout.service;

import com.example.birdscout.entity.User;

public interface UserService {
    User createUser(User user, String roleName);
    User getUserByUsername(String username);
}
