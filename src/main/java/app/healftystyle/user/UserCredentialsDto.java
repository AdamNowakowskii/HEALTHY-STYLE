package app.healftystyle.user;

import java.util.Set;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserCredentialsDto {
    @NotEmpty
    @Email
    private final String email;
    @Length(min = 8, max = 16)
    private final String password;
    @NotEmpty
    private final Set<String> roles;
}
