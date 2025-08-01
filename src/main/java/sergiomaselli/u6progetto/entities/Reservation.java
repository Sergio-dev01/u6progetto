package sergiomaselli.u6progetto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event evento;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private User utente;

    private int postiPrenotati;

    private LocalDateTime dataPrenotazione;
}
