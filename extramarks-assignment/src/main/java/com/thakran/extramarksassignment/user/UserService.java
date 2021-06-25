package com.thakran.extramarksassignment.user;

import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("Email already registered!!");
        }
        userRepository.save(user);
    }

    public User getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new IllegalStateException("User not registered properly!!");
        }
    }

    public User getCurrentUser() {
        Optional<User> user = userRepository.findLastUser();
        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new IllegalStateException("No users found!");
        }
    }
}
