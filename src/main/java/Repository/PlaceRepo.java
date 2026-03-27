package Repository;

import Model.Coach;
import Model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepo extends JpaRepository<Place,Long> {
}
