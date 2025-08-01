package sergiomaselli.u6progetto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sergiomaselli.u6progetto.entities.Reservation;

import java.util.List;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    List<Reservation> findByUtenteId(UUID utenteId);

    List<Reservation> findByEventoId(UUID eventoId);
}
