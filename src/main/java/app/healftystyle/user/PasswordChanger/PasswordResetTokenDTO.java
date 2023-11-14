package app.healftystyle.user.PasswordChanger;

import java.time.LocalDateTime;

import app.healftystyle.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PasswordResetTokenDTO {
    private String token;
    private User user;
    private LocalDateTime expiryDate;
}
