package com.adriana.goaltracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "progress_entries")
public class ProgressEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate entryDate;

    private Double value;

    private String note;

    @ManyToOne
    @JoinColumn(name = "goal_id", nullable = false)
    @JsonIgnore
    private Goal goal;

    public ProgressEntry() {}

    public ProgressEntry(LocalDate entryDate, Double value, String note) {
        this.entryDate = entryDate;
        this.value = value;
        this.note = note;
    }

    public Long getId() { return id; }
    public LocalDate getEntryDate() { return entryDate; }
    public Double getValue() { return value; }
    public String getNote() { return note; }
    public Goal getGoal() { return goal; }

    public void setId(Long id) { this.id = id; }
    public void setEntryDate(LocalDate entryDate) { this.entryDate = entryDate; }
    public void setValue(Double value) { this.value = value; }
    public void setNote(String note) { this.note = note; }
    public void setGoal(Goal goal) { this.goal = goal; }
}