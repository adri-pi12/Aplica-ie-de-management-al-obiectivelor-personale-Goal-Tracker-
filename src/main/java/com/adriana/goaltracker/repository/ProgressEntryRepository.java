package com.adriana.goaltracker.repository;

import com.adriana.goaltracker.model.ProgressEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressEntryRepository extends JpaRepository<ProgressEntry, Long> {
}