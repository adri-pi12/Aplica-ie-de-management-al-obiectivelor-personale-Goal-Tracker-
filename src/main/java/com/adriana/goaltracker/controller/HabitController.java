package com.adriana.goaltracker.controller;

import com.adriana.goaltracker.model.Habit;
import com.adriana.goaltracker.service.HabitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

    private final HabitService service;

    public HabitController(HabitService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Habit>> all() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habit> one(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Habit> create(@RequestBody Habit habit, @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(habit, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habit> update(@PathVariable Long id, @RequestBody Habit habit) {
        return ResponseEntity.ok(service.update(id, habit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}