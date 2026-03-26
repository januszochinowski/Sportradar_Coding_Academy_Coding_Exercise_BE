package Repository;

import Model.Coach;
import Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team,Long> {
}
