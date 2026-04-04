package com.adriana.goaltracker.service;

import com.adriana.goaltracker.exception.ResourceNotFoundException;
import com.adriana.goaltracker.model.Habit;
import com.adriana.goaltracker.model.User;
import com.adriana.goaltracker.repository.HabitRepository;
import com.adriana.goaltracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final UserRepository userRepository;

    public HabitService(HabitRepository habitRepository, UserRepository userRepository) {
        this.habitRepository = habitRepository;
        this.userRepository = userRepository;
    }

    public List<Habit> getAll() {
        return habitRepository.findAll();
    }

    public Habit getById(Long id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Habit not found with id: " + id));
    }

    public Habit create(Habit habit, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        habit.setUser(user);
        return habitRepository.save(habit);
    }

    public Habit update(Long id, Habit updatedHabit) {
        Habit existing = getById(id);

        existing.setName(updatedHabit.getName());
        existing.setFrequency(updatedHabit.getFrequency());
        existing.setTargetValue(updatedHabit.getTargetValue());

        return habitRepository.save(existing);
    }

    public void delete(Long id) {
        Habit existing = getById(id);
        habitRepository.delete(existing);
    }
}