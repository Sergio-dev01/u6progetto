package sergiomaselli.u6progetto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import sergiomaselli.u6progetto.entities.Event;
import sergiomaselli.u6progetto.entities.User;
import sergiomaselli.u6progetto.services.EventService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/eventi")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public Event creaEvento(@RequestBody Event evento, @AuthenticationPrincipal User utente) {
        return eventService.creaEvento(evento, utente);
    }

    @GetMapping
    public List<Event> listaEventi() {
        return eventService.getTuttiGliEventi();
    }

    @GetMapping("/miei")
    public List<Event> mieiEventi(@AuthenticationPrincipal User utente) {
        return eventService.getEventiCreatiDa(utente);
    }

    @PutMapping("/{id}")
    public Event modificaEvento(@PathVariable UUID id, @RequestBody Event eventoAggiornato, @AuthenticationPrincipal User utente) {
        return eventService.updateEvento(id, eventoAggiornato, utente);
    }

    @DeleteMapping("/{id}")
    public void eliminaEvento(@PathVariable UUID id, @AuthenticationPrincipal User utente) {
        eventService.deleteEvent(id, utente);
    }
}
