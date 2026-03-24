package com.BusyBrains.backend.service;
import com.BusyBrains.backend.entity.User;
import com.BusyBrains.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // REGISTER
    public User register(User user) {
        return userRepository.save(user);
    }

    // LOGIN
    public User login(String username, String password) {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (user.getPassword().equals(password)) {
                return user;
            }
        }

        return null; // invalid login
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(Long id, User updatedUser) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setUsername(updatedUser.getUsername());
            return userRepository.save(user);
        }

        return null;
    }

    public User changePassword(Long id, String newPassword) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setPassword(newPassword);
            return userRepository.save(user);
        }

        return null;
    }
}