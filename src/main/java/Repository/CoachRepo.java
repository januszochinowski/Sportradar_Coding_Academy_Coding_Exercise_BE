package Repository;

import Model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepo extends JpaRepository<Coach,Long> {
}
