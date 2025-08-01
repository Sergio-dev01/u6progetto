package sergiomaselli.u6progetto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import sergiomaselli.u6progetto.entities.Reservation;
import sergiomaselli.u6progetto.entities.User;
import sergiomaselli.u6progetto.services.ReservationService;

import java.util.UUID;

@RestController
@RequestMapping("/prenotazioni")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/{eventoId}")
    @PreAuthorize("hasRole('USER')")
    public Reservation prenota(@PathVariable UUID eventoId,
                               @AuthenticationPrincipal User user,
                               @RequestParam int posti) {
        return reservationService.prenota(eventoId, user, posti);
    }
}
