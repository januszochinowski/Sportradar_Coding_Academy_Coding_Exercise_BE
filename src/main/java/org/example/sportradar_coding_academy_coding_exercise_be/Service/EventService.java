package org.example.sportradar_coding_academy_coding_exercise_be.Service;

import jakarta.persistence.EntityNotFoundException;
import org.example.sportradar_coding_academy_coding_exercise_be.Model.Event;
import org.example.sportradar_coding_academy_coding_exercise_be.Model.Place;
import org.example.sportradar_coding_academy_coding_exercise_be.Repository.EventRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    private final EventRepo repo;
    private final Sort sort = Sort.by("eventDate");

    public EventService( EventRepo repo) {
        this.repo = repo;
    }

    public void add(Event event) {
        repo.save(event);
    }

    public void update(Event event) {
        repo.save(event);
    }

    public Event getById(long id) {
       return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Event with id " + id + " not found!"));
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public List<Event> getAll(int page, int size) {
       return repo.findAll(PageRequest.of(page, size,sort)).getContent();
    }

    public List<Event> getByPlace(Place place, int page, int size) {
        return repo.findByPlace(place, PageRequest.of(page, size,sort)).getContent();
    }

    public List<Event> getByAfter(LocalDate after, int page, int size) {
        return repo.findByAfter(after, PageRequest.of(page, size,sort)).getContent();
    }

    public List<Event> getByBetween(LocalDate start, LocalDate finished, int page, int size) {
        return repo.findByBetween(start, finished, PageRequest.of(page, size,sort)).getContent();
    }

    public List<Event> getBySportName(String sportName, int page, int size) {
        return repo.findBySportName(sportName, PageRequest.of(page, size,sort)).getContent();
    }


}
