package com.adriana.goaltracker.service;

import com.adriana.goaltracker.model.Goal;
import com.adriana.goaltracker.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository repo;

    public GoalService(GoalRepository repo) {
        this.repo = repo;
    }

    public List<Goal> getAll() {
        return repo.findAll();
    }

    public Goal create(Goal goal) {
        return repo.save(goal);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}