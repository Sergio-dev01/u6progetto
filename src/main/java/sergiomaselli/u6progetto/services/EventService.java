package sergiomaselli.u6progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sergiomaselli.u6progetto.entities.Event;
import sergiomaselli.u6progetto.entities.User;
import sergiomaselli.u6progetto.repositories.EventRepository;

import java.util.List;
import java.util.UUID;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepo;

    public Event creaEvento(Event e, User creatore) {
        e.setCreatore(creatore);
        return eventRepo.save(e);
    }

    public List<Event> listaEventi() {
        return eventRepo.findAll();
    }

    public Event modificaEvento(UUID id, Event nuovoevent, User user) {
        Event e = eventRepo.findById(id).orElseThrow(() -> new RuntimeException("Evento non trovato"));
        if (!e.getCreatore().getId().equals(user.getId()))
            throw new RuntimeException("Non puoi modificare questo evento");

        e.setTitolo(nuovoevent.getTitolo());
        e.setDescrizione(nuovoevent.getDescrizione());
        e.setData(nuovoevent.getData());
        e.setLuogo(nuovoevent.getLuogo());
        e.setPostiDisponibili(nuovoevent.getPostiDisponibili());
        return eventRepo.save(e);
    }

    public void eliminaEvento(UUID id, User user) {
        Event e = eventRepo.findById(id).orElseThrow(() -> new RuntimeException("Evento non trovato"));
        if (!e.getCreatore().getId().equals(user.getId()))
            throw new RuntimeException("Non puoi eliminare questo evento");
        eventRepo.delete(e);
    }
}
