package sergiomaselli.u6progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sergiomaselli.u6progetto.entities.User;
import sergiomaselli.u6progetto.payloads.NewUserDTO;
import sergiomaselli.u6progetto.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(NewUserDTO payload) {
        User user = new User();
        user.setEmail(payload.getEmail());
        user.setName(payload.getNome());
        user.setPassword(passwordEncoder.encode(payload.getPassword()));
        user.setRole(payload.getRole());

        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
