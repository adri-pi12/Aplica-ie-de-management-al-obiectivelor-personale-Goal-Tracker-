package com.adriana.goaltracker.repository;

import com.adriana.goaltracker.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}