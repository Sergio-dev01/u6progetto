package sergiomaselli.u6progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sergiomaselli.u6progetto.entities.User;
import sergiomaselli.u6progetto.payloads.LoginDTO;
import sergiomaselli.u6progetto.tools.JWTTools;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTTools jwtTools;

    public String checkCredentialsAndGenerateToken(LoginDTO body) {
        User user = userService.findByEmail(body.getEmail());
        if (user == null || !passwordEncoder.matches(body.getPassword(), user.getPassword())) {
            throw new RuntimeException("Credenziali non valide");
        }
        return jwtTools.createToken(user);
    }
}
