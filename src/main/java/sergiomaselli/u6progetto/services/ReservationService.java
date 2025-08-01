package sergiomaselli.u6progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sergiomaselli.u6progetto.entities.Event;
import sergiomaselli.u6progetto.entities.Reservation;
import sergiomaselli.u6progetto.entities.User;
import sergiomaselli.u6progetto.repositories.EventRepository;
import sergiomaselli.u6progetto.repositories.ReservationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepo;
    @Autowired
    private EventRepository eventRepo;

    public Reservation prenota(UUID eventoId, User utente, int posti) {
        Event e = eventRepo.findById(eventoId).orElseThrow(() -> new RuntimeException("Evento non trovato"));
        if (e.getPostiDisponibili() < posti) {
            throw new RuntimeException("Posti insufficienti disponibili");
        }
        e.setPostiDisponibili(e.getPostiDisponibili() - posti);
        eventRepo.save(e);

        Reservation r = new Reservation();
        r.setEvento(e);
        r.setUtente(utente);
        r.setPostiPrenotati(posti);
        r.setDataPrenotazione(LocalDateTime.now());
        return reservationRepo.save(r);
    }

    public List<Reservation> getPrenotazioniByUtente(UUID utenteId) {
        return reservationRepo.findByUtenteId(utenteId);
    }

    public List<Reservation> getPrenotazioniByEvento(UUID eventoId) {
        return reservationRepo.findByEventoId(eventoId);
    }
}
