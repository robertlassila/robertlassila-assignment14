package com.coderscampus.assignment14.service;

import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public  UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    public Optional<User> findByName(String name) {
        List<User> users = userRepository.findAllByName(name);

        Optional<User> user = users.stream().findFirst();

        return user;
    }

}
