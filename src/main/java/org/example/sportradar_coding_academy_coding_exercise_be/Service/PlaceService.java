package org.example.sportradar_coding_academy_coding_exercise_be.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.sportradar_coding_academy_coding_exercise_be.Model.Place;
import org.example.sportradar_coding_academy_coding_exercise_be.Repository.EventRepo;
import org.example.sportradar_coding_academy_coding_exercise_be.Repository.PlaceRepo;
import org.springframework.stereotype.Service;

@Service
public class PlaceService {
    private final PlaceRepo repo;

    public PlaceService(PlaceRepo repo) {
        this.repo = repo;
    }

    public void add(Place place) {
        repo.save(place);
    }

    public void update(Place place) {
        repo.save(place);
    }

    public void delete(Place place) {
        repo.delete(place);
    }

    public Place getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Place with id " + id + " not found!"));
    }
}
