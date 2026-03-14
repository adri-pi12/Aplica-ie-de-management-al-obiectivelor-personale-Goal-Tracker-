package com.adriana.goaltracker.service;

import com.adriana.goaltracker.model.User;
import com.adriana.goaltracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User create(User user) {
        return repository.save(user);
    }

    public User update(Long id, User updatedUser) {
        User existing = getById(id);

        existing.setFullName(updatedUser.getFullName());
        existing.setEmail(updatedUser.getEmail());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}