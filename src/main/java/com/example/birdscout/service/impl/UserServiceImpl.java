package com.example.birdscout.service.impl;

import com.example.birdscout.entity.Role;
import com.example.birdscout.entity.User;
import com.example.birdscout.repository.RoleRepository;
import com.example.birdscout.repository.UserRepository;
import com.example.birdscout.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user, String roleName) {
        // Encode the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set default role
        Role role = roleRepository.findByRoleName(roleName);
        if (role == null) {
            role = new Role();
            role.setRoleName(roleName);
            roleRepository.save(role);
        }
        user.getRoles().add(role);

        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
