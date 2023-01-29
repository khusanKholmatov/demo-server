package com.example.demoserver.service;

import com.example.demoserver.model.User;
import com.example.demoserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getById(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        return optionalUser.orElse(null);
    }

    public User addUser(User user) {

        if (!userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null;
    }

    public User editUser(User user) {
        if (!userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null;
    }

    public String deleteUser(Integer userId) {
        if (!userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return "deleted successfully";
        }
        return "not found";
    }
}
