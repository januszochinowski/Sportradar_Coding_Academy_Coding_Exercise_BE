package Repository;

import Model.Coach;
import Model.Event;
import Model.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {

    @Query("SELECT e FROM Event e WHERE e.place = :place")
    Page<Event> findByPlace(Place place, Pageable pageable);

    @Query("SELECT e FROM Event e WHERE e.eventDate > :start ")
    Page<Event> findByAfter(Date after, Pageable pageable);

    @Query("SELECT e FROM Event e WHERE e.eventDate > :start AND e.eventDate < :finished")
    Page<Event> findByIdBetween(Date start, Date finished, Pageable pageable);

    @Query("SELECT  e FROM Event  e WHERE e.sportName = :sportName")
    Page<Event> findBySportName(String sportName, Pageable pageable);
}
