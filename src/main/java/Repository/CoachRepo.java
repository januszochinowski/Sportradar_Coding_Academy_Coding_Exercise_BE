package Repository;

import Model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestHeader;

@Repository
public interface CoachRepo extends JpaRepository<Coach,Long> {
}
