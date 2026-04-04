package com.adriana.goaltracker.controller;

import com.adriana.goaltracker.model.Milestone;
import com.adriana.goaltracker.service.MilestoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milestones")
public class MilestoneController {

    private final MilestoneService service;

    public MilestoneController(MilestoneService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Milestone>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Milestone> one(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/goal/{goalId}")
    public ResponseEntity<Milestone> create(@RequestBody Milestone milestone, @PathVariable Long goalId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(milestone, goalId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Milestone> update(@PathVariable Long id, @RequestBody Milestone milestone) {
        return ResponseEntity.ok(service.update(id, milestone));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}