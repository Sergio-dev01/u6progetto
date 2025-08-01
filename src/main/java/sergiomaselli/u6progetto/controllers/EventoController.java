package sergiomaselli.u6progetto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import sergiomaselli.u6progetto.entities.Event;
import sergiomaselli.u6progetto.entities.User;
import sergiomaselli.u6progetto.services.EventService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/eventi")
public class EventoController {
    @Autowired
    private EventService eventService;

    @PostMapping
    @PreAuthorize("hasRole('ORGANIZER')")
    public Event crea(@RequestBody Event e, @AuthenticationPrincipal User user) {
        return eventService.creaEvento(e, user);
    }

    @GetMapping
    public List<Event> lista() {
        return eventService.listaEventi();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ORGANIZER')")
    public Event modifica(@PathVariable UUID id, @RequestBody Event e, @AuthenticationPrincipal User user) {
        return eventService.modificaEvento(id, e, user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ORGANIZER')")
    public void elimina(@PathVariable UUID id, @AuthenticationPrincipal User user) {
        eventService.eliminaEvento(id, user);
    }
}
