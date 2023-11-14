package app.healftystyle.user;


import static jakarta.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import app.healftystyle.UserRole.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    @Length(min = 8, max = 16)
    private String password;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    @NotEmpty
    private final List<UserRole> roles = new ArrayList<>();

}

