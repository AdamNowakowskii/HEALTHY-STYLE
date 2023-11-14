package app.healftystyle.config;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegistrationDTO {
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size
    private String password;
}
