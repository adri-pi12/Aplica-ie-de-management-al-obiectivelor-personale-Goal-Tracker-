package com.adriana.goaltracker.service;

import com.adriana.goaltracker.exception.ResourceNotFoundException;
import com.adriana.goaltracker.model.Goal;
import com.adriana.goaltracker.model.User;
import com.adriana.goaltracker.repository.GoalRepository;
import com.adriana.goaltracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    public GoalService(GoalRepository goalRepository, UserRepository userRepository) {
        this.goalRepository = goalRepository;
        this.userRepository = userRepository;
    }

    public List<Goal> getAll() {
        return goalRepository.findAll();
    }

    public Goal getById(Long id) {
        return goalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found with id: " + id));
    }

    public Goal create(Goal goal, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        goal.setUser(user);
        return goalRepository.save(goal);
    }

    public void delete(Long id) {
        Goal existing = getById(id);
        goalRepository.delete(existing);
    }
}