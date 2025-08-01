package sergiomaselli.u6progetto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import sergiomaselli.u6progetto.entities.Role;
import sergiomaselli.u6progetto.entities.User;
import sergiomaselli.u6progetto.repositories.UserRepository;

public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String name, String email, String password, Role role) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setRole(role);
        return userRepository.save(newUser);
    }
    
}

