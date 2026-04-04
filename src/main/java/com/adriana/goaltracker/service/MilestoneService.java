package com.adriana.goaltracker.service;

import com.adriana.goaltracker.exception.ResourceNotFoundException;
import com.adriana.goaltracker.model.Goal;
import com.adriana.goaltracker.model.Milestone;
import com.adriana.goaltracker.repository.GoalRepository;
import com.adriana.goaltracker.repository.MilestoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;
    private final GoalRepository goalRepository;

    public MilestoneService(MilestoneRepository milestoneRepository, GoalRepository goalRepository) {
        this.milestoneRepository = milestoneRepository;
        this.goalRepository = goalRepository;
    }

    public List<Milestone> getAll() {
        return milestoneRepository.findAll();
    }

    public Milestone getById(Long id) {
        return milestoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Milestone not found with id: " + id));
    }

    public Milestone create(Milestone milestone, Long goalId) {
        Goal goal = goalRepository.findById(goalId)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found with id: " + goalId));

        milestone.setGoal(goal);
        return milestoneRepository.save(milestone);
    }

    public Milestone update(Long id, Milestone updatedMilestone) {
        Milestone existing = getById(id);

        existing.setTitle(updatedMilestone.getTitle());
        existing.setCompleted(updatedMilestone.isCompleted());
        existing.setDeadline(updatedMilestone.getDeadline());

        return milestoneRepository.save(existing);
    }

    public void delete(Long id) {
        Milestone existing = getById(id);
        milestoneRepository.delete(existing);
    }
}