package sergiomaselli.u6progetto.payloads;

import java.util.UUID;

public class NewUserRespDTO {
    private UUID id;

    public NewUserRespDTO(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
