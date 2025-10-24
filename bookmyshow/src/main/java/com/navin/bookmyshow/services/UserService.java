package com.navin.bookmyshow.services;

import com.navin.bookmyshow.models.User;
import com.navin.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User signUp(
            String email,
            String password) {
        // 1. check if user already exists
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new RuntimeException("User already present!");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setBookings(new ArrayList<>());

        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
