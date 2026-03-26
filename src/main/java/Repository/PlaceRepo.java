package Repository;

import Model.Coach;
import Model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepo extends JpaRepository<Place,Long> {
}
