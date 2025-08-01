package sergiomaselli.u6progetto.payloads;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class NewEventDTO {
    private String titolo;
    private String descrizione;
    private LocalDate data;
    private String luogo;
    private int postiDisponibili;
}