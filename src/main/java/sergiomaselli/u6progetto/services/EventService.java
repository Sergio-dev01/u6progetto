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
    private EventRepository eventoRepository;

    public Event creaEvento(Event event, User creatore) {
        event.setCreatore(creatore);
        return eventoRepository.save(event);
    }

    public List<Event> getEventiCreatiDa(User user) {
        return eventoRepository.findByCreatoreId(user.getId());
    }

    public List<Event> getTuttiGliEventi() {
        return eventoRepository.findAll();
    }

    public Event findById(UUID id) {
        return eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento non trovato"));
    }

    public void deleteEvent(UUID id, User richiedente) {
        Event evento = findById(id);
        if (!evento.getCreatore().getId().equals(richiedente.getId())) {
            throw new RuntimeException("Non puoi eliminare un evento che non hai creato");
        }
        eventoRepository.delete(evento);
    }

    public Event updateEvento(UUID id, Event eventoAggiornato, User richiedente) {
        Event eventoEsistente = findById(id);
        if (!eventoEsistente.getCreatore().getId().equals(richiedente.getId())) {
            throw new RuntimeException("Non puoi modificare un evento che non hai creato");
        }
        eventoEsistente.setTitolo(eventoAggiornato.getTitolo());
        eventoEsistente.setDescrizione(eventoAggiornato.getDescrizione());
        eventoEsistente.setData(eventoAggiornato.getData());
        eventoEsistente.setLuogo(eventoAggiornato.getLuogo());
        eventoEsistente.setPostiDisponibili(eventoAggiornato.getPostiDisponibili());
        return eventoRepository.save(eventoEsistente);
    }
}

