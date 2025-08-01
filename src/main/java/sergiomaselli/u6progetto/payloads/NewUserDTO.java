package sergiomaselli.u6progetto.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import sergiomaselli.u6progetto.entities.Role;

public class NewUserDTO {
    @Email(message = "Email non valida")
    @NotBlank(message = "Email obbligatoria")
    private String email;

    @NotBlank(message = "Password obbligatoria")
    @Size(min = 6, message = "La password deve essere almeno di 6 caratteri")
    private String password;

    @NotBlank(message = "Nome obbligatorio")
    private String nome;

    private Role role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Role getRole() {
        return role;
    }
}
