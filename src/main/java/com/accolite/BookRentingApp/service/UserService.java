package com.accolite.BookRentingApp.service;

import com.accolite.BookRentingApp.model.User;
import com.accolite.BookRentingApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to update user details
    public Optional<User> updateUser(Long userId, User user) {
            return Optional.of(userRepository.save(user));
    }
}
