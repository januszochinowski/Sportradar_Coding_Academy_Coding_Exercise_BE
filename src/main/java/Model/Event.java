package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    LocalDate eventDate;

    @Column(nullable = false)
    String sportName;

    @Column(nullable = false)
    LocalTime eventTime;

    @ManyToOne
    @JoinColumn(name = "_foreignkey_team1_id")
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "_foreignkey_team2_id")
    private Team team2;


    @ManyToOne
    @JoinColumn(name = "_foreignkey_place_id")
    private Place place;


}
