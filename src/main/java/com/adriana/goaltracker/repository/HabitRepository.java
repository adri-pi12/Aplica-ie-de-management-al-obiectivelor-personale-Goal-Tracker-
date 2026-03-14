package com.adriana.goaltracker.repository;

import com.adriana.goaltracker.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long> {
}