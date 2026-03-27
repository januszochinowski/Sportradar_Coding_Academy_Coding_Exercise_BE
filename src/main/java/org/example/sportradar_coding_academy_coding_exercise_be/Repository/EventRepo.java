package org.example.sportradar_coding_academy_coding_exercise_be.Repository;

import org.example.sportradar_coding_academy_coding_exercise_be.Model.Event;
import org.example.sportradar_coding_academy_coding_exercise_be.Model.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {

    @Query("SELECT e FROM Event e WHERE e.place = :place")
    Page<Event> findByPlace(Place place, Pageable pageable);

    @Query("SELECT e FROM Event e WHERE e.eventDate >= :after ")
    Page<Event> findByAfter(LocalDate after, Pageable pageable);

    @Query("SELECT e FROM Event e WHERE e.eventDate > :start AND e.eventDate < :finished")
    Page<Event> findByBetween(LocalDate start, LocalDate finished, Pageable pageable);

    @Query("SELECT  e FROM Event  e WHERE e.sportName = :sportName")
    Page<Event> findBySportName(String sportName, Pageable pageable);
}
