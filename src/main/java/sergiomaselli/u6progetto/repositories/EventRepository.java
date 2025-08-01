package sergiomaselli.u6progetto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sergiomaselli.u6progetto.entities.Event;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    List<Event> findByCreatoreId(UUID creatoreId);
}
