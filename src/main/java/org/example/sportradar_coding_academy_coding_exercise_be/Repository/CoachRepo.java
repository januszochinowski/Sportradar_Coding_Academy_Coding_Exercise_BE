package org.example.sportradar_coding_academy_coding_exercise_be.Repository;

import org.example.sportradar_coding_academy_coding_exercise_be.Model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepo extends JpaRepository<Coach,Long> {
}
