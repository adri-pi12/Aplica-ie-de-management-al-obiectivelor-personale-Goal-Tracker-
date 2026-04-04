package com.adriana.goaltracker.controller;

import com.adriana.goaltracker.model.ProgressEntry;
import com.adriana.goaltracker.service.ProgressEntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ProgressEntry>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgressEntry> one(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/goal/{goalId}")
    public ResponseEntity<ProgressEntry> create(@RequestBody ProgressEntry progressEntry, @PathVariable Long goalId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(progressEntry, goalId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgressEntry> update(@PathVariable Long id, @RequestBody ProgressEntry progressEntry) {
        return ResponseEntity.ok(service.update(id, progressEntry));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}