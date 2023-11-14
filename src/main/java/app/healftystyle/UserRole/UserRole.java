package app.healftystyle.UserRole;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
