package com.adriana.goaltracker.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;

@Entity
@Table(name = "milestones")
public class Milestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private boolean completed;

    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "goal_id", nullable = false)
    @JsonIgnore
    private Goal goal;

    public Milestone() {}

    public Milestone(String title, boolean completed, LocalDate deadline) {
        this.title = title;
        this.completed = completed;
        this.deadline = deadline;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }
    public LocalDate getDeadline() { return deadline; }
    public Goal getGoal() { return goal; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setCompleted(boolean completed) { this.completed = completed; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }
    public void setGoal(Goal goal) { this.goal = goal; }
}
