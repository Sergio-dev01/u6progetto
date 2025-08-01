package sergiomaselli.u6progetto.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Event {
    @Id
    @GeneratedValue
    private UUID id;

    private String titolo;
    private String descrizione;
    private LocalDate data;
    private String luogo;
    private int postiDisponibili;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    @JsonIgnoreProperties({"password", "eventiCreati"})
    private User creatore;
}

