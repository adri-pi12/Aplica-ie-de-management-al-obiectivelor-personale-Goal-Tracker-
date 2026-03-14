package com.adriana.goaltracker.controller;

import com.adriana.goaltracker.model.ProgressEntry;
import com.adriana.goaltracker.service.ProgressEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/progress-entries")
public class ProgressEntryController {

    private final ProgressEntryService service;

    public ProgressEntryController(ProgressEntryService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProgressEntry> all() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProgressEntry one(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/goal/{goalId}")
    public ProgressEntry create(@RequestBody ProgressEntry progressEntry, @PathVariable Long goalId) {
        return service.create(progressEntry, goalId);
    }

    @PutMapping("/{id}")
    public ProgressEntry update(@PathVariable Long id, @RequestBody ProgressEntry progressEntry) {
        return service.update(id, progressEntry);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}