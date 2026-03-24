package com.BusyBrains.backend.config;

import com.BusyBrains.backend.entity.User;
import com.BusyBrains.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(UserRepository repo) {
        return args -> {
            repo.save(new User(null, "admin", "admin123", "ADMIN"));
            repo.save(new User(null, "user", "user123", "USER"));
        };
    }
}