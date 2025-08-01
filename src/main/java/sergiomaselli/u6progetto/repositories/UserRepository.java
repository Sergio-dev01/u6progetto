package sergiomaselli.u6progetto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sergiomaselli.u6progetto.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
