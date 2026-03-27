package org.example.sportradar_coding_academy_coding_exercise_be.Repository;

import org.example.sportradar_coding_academy_coding_exercise_be.Model.Coach;
import org.example.sportradar_coding_academy_coding_exercise_be.Model.Event;
import org.example.sportradar_coding_academy_coding_exercise_be.Model.Place;
import org.example.sportradar_coding_academy_coding_exercise_be.Model.Team;
import org.example.sportradar_coding_academy_coding_exercise_be.Repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EventRepoTest {

    @Autowired
    private EventRepo repo;

    @Autowired
    private CoachRepo coachRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private PlaceRepo placeRepo;

    @Autowired
    private TeamRepo teamRepo;

    Place place;
    Place place2;

    Event event;
    Event event2;

    LocalDate event1Date;
    LocalDate event2Date;
    
    private final PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("eventDate").descending());

    @BeforeEach
    void setUp() {
        Coach coach = new Coach();
        coach.setName("Coach");
        coach.setSurname("Surname");
        coach.setAge(20);
        coachRepo.save(coach);

        Coach coach2 = new Coach();
        coach2.setName("Coach");
        coach2.setSurname("Surname");
        coach2.setAge(30);
        coachRepo.save(coach2);

        place = new Place();
        place.setName("Place");
        place.setCity("Warsaw");
        place.setMax_Capacity(2000);
        placeRepo.save(place);

        place2 = new Place();
        place2.setName("Place2");
        place2.setCity("Berlin");
        place2.setMax_Capacity(4000);
        placeRepo.save(place2);

        Team team = new Team();
        team.setName("Team");
        team.setCoach(coach);
        team.setCity("Warsaw");
        teamRepo.save(team);

        Team team2 = new Team();
        team2.setName("Team2");
        team2.setCoach(coach2);
        team2.setCity("Berlin");
        teamRepo.save(team2);


        event = new Event();
        event.setSportName("football");
        event.setPlace(place);
        event.setTeam1(team);
        event.setTeam2(team2);
        event.setEventDate(LocalDate.now().plusDays(20));
        event.setEventTime(LocalTime.now());
        repo.save(event);


        event2 = new Event();
        event2.setSportName("football");
        event2.setPlace(place2);
        event2.setTeam1(team2);
        event2.setTeam2(team);
        event2.setEventDate(LocalDate.now().plusDays(50));
        event2.setEventTime(LocalTime.now());
        repo.save(event2);
    }


    @Test
    void findByPlace() {

        assertArrayEquals(new Event[] {event},repo.findByPlace(place.getName(), pageRequest).getContent().toArray());
        assertArrayEquals(new Event[]{event2},repo.findByPlace(place2.getName(), pageRequest).getContent().toArray());

    }

    @Test
    void findByAfter() {
        assertArrayEquals( new Event[]{event2,event}, repo.findByAfter(event.getEventDate(),pageRequest).getContent().toArray());
        assertArrayEquals(new Event[] {event2}, repo.findByAfter(event2.getEventDate(),pageRequest).getContent().toArray());
    }

    @Test
    void findByBetween() {
        assertArrayEquals(new Event[]{event}, repo.findByBetween(event.getEventDate().minusDays(1),event2.getEventDate().minusDays(1),pageRequest).getContent().toArray());

    }

    @Test
    void findBySportName() {
        assertArrayEquals(new Event[]{event2,event}, repo.findBySportName(event.getSportName(),pageRequest).getContent().toArray());
        event.setSportName("basketball");
        repo.save(event);
        assertArrayEquals(new Event[]{event}, repo.findBySportName(event.getSportName(),pageRequest).getContent().toArray());

    }

}