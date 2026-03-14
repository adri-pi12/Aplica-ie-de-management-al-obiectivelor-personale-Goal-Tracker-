package com.adriana.goaltracker.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "goals")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private String status;

    private LocalDate targetDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Milestone> milestones = new ArrayList<>();

    @OneToMany(mappedBy = "goal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgressEntry> progressEntries = new ArrayList<>();

    public Goal() {}

    public Goal(String title, String description, String status, LocalDate targetDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.targetDate = targetDate;
    }

    public void addMilestone(Milestone milestone) {
        milestones.add(milestone);
        milestone.setGoal(this);
    }

    public void addProgressEntry(ProgressEntry entry) {
        progressEntries.add(entry);
        entry.setGoal(this);
    }

    public void removeMilestone(Milestone milestone) {
        milestones.remove(milestone);
        milestone.setGoal(null);
    }

    public void removeProgressEntry(ProgressEntry entry) {
        progressEntries.remove(entry);
        entry.setGoal(null);
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public LocalDate getTargetDate() { return targetDate; }
    public User getUser() { return user; }
    public List<Milestone> getMilestones() { return milestones; }
    public List<ProgressEntry> getProgressEntries() { return progressEntries; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }
    public void setTargetDate(LocalDate targetDate) { this.targetDate = targetDate; }
    public void setUser(User user) { this.user = user; }
    public void setMilestones(List<Milestone> milestones) { this.milestones = milestones; }
    public void setProgressEntries(List<ProgressEntry> progressEntries) { this.progressEntries = progressEntries; }
}