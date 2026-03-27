package Repository;

import Model.Coach;
import Model.Event;
import Model.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface EventRepo extends JpaRepository<Event,Long> {

    Page<Event> findByPlace(Place place, Pageable pageable);

    Page<Event> findByAfter(Date after, Pageable pageable);

    @Query("SELECT e FROM Event e WHERE e.eventDate > :start AND e.eventDate < :finished")
    Page<Event> findByIdBetween(Date start, Date finished, Pageable pageable);

    Page<Event> findBySportName(String sportName, Pageable pageable);
}
