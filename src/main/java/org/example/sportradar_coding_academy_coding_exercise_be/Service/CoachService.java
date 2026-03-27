package org.example.sportradar_coding_academy_coding_exercise_be.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.sportradar_coding_academy_coding_exercise_be.Model.Coach;
import org.example.sportradar_coding_academy_coding_exercise_be.Repository.CoachRepo;
import org.springframework.stereotype.Service;

@Service
public class CoachService {

    public CoachRepo repo;

    public CoachService(CoachRepo repo) {
        this.repo = repo;
    }

    public void add(Coach coach) {
        repo.save(coach);
    }

    public void delete(Coach coach) {
        repo.delete(coach);
    }

    public void update(Coach coach) {
        repo.save(coach);
    }

    public Coach getById(long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Coach with id " + id + " not found!"));
    }
}
