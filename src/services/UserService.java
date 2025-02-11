package com.example.petadoption.service;

import com.example.petadoption.model.User;
import com.example.petadoption.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User createUser(User user) {
        if (userRepository.existsByLogin(user.getLogin())) {
            throw new RuntimeException("User already exists");
        }
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setLogin(updatedUser.getLogin());
                    user.setPassword(updatedUser.getPassword());
                    user.setAccessLevel(updatedUser.getAccessLevel());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(String login) {
        userRepository.deleteByLogin(login);
    }
}
