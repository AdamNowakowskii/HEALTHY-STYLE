package app.healftystyle.user.PasswordChanger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
    PasswordResetTokenDTO deleteByToken(String token);

}
