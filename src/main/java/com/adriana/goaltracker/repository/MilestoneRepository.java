package com.adriana.goaltracker.repository;

import com.adriana.goaltracker.model.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
}