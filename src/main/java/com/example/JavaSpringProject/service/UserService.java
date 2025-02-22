package com.example.JavaSpringProject.service;

import org.springframework.stereotype.Service;

import com.example.JavaSpringProject.domain.User;
import com.example.JavaSpringProject.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }
}
