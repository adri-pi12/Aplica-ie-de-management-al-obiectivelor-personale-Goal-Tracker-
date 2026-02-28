package com.adriana.goaltracker.service;

import com.adriana.goaltracker.model.User;
import com.adriana.goaltracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    public User create(User user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already used: " + user.getEmail());
        }
        return repo.save(user);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("User not found: " + id);
        }
        repo.deleteById(id);
    }
}
