package app.healftystyle.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long > {
    Optional<User> findCredentialsByEmail(String email);
    Optional<User> findByEmail (String email);
    User findUserByEmail (String email);
}
