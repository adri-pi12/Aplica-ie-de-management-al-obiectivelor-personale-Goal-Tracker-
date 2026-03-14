package com.adriana.goaltracker.service;

import com.adriana.goaltracker.model.Goal;
import com.adriana.goaltracker.model.ProgressEntry;
import com.adriana.goaltracker.repository.GoalRepository;
import com.adriana.goaltracker.repository.ProgressEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressEntryService {

    private final ProgressEntryRepository progressEntryRepository;
    private final GoalRepository goalRepository;

    public ProgressEntryService(ProgressEntryRepository progressEntryRepository, GoalRepository goalRepository) {
        this.progressEntryRepository = progressEntryRepository;
        this.goalRepository = goalRepository;
    }

    public List<ProgressEntry> getAll() {
        return progressEntryRepository.findAll();
    }

    public ProgressEntry getById(Long id) {
        return progressEntryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProgressEntry not found with id: " + id));
    }

    public ProgressEntry create(ProgressEntry progressEntry, Long goalId) {
        Goal goal = goalRepository.findById(goalId)
                .orElseThrow(() -> new RuntimeException("Goal not found with id: " + goalId));

        progressEntry.setGoal(goal);
        return progressEntryRepository.save(progressEntry);
    }

    public ProgressEntry update(Long id, ProgressEntry updatedEntry) {
        ProgressEntry existing = getById(id);

        existing.setEntryDate(updatedEntry.getEntryDate());
        existing.setValue(updatedEntry.getValue());
        existing.setNote(updatedEntry.getNote());

        return progressEntryRepository.save(existing);
    }

    public void delete(Long id) {
        progressEntryRepository.deleteById(id);
    }
}