package com.adriana.goaltracker.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "habits")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String frequency;

    private Integer targetValue;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
    public Habit() {}

    public Habit(String name, String frequency, Integer targetValue) {
        this.name = name;
        this.frequency = frequency;
        this.targetValue = targetValue;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getFrequency() { return frequency; }
    public Integer getTargetValue() { return targetValue; }
    public User getUser() { return user; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    public void setTargetValue(Integer targetValue) { this.targetValue = targetValue; }
    public void setUser(User user) { this.user = user; }
}
