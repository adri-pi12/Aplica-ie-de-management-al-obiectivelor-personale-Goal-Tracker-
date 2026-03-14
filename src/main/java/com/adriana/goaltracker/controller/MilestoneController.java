package com.adriana.goaltracker.controller;

import com.adriana.goaltracker.model.Milestone;
import com.adriana.goaltracker.service.MilestoneService;
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
    public List<Milestone> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Milestone one(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/goal/{goalId}")
    public Milestone create(@RequestBody Milestone milestone, @PathVariable Long goalId) {
        return service.create(milestone, goalId);
    }

    @PutMapping("/{id}")
    public Milestone update(@PathVariable Long id, @RequestBody Milestone milestone) {
        return service.update(id, milestone);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}