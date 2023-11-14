package app.healftystyle.user;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import app.healftystyle.UserRole.UserRole;
import app.healftystyle.UserRole.UserRoleRepository;
import app.healftystyle.config.UserRegistrationDTO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private static final String DEFAULT_USER_ROLE = "USER";

    private final UserRepository repository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    public Optional<UserCredentialsDto> findCredentialsByEmail(String email) {
        return repository.findByEmail(email)
                .map(UserCredentialsDtoMapper::map);
    }
    @Transactional
    public void registerUserWithDefaultRole(UserRegistrationDTO userRegistration) {
        UserRole defaultRole = userRoleRepository.findByName(DEFAULT_USER_ROLE).orElseThrow();
        User user = new User();
        user.setEmail(userRegistration.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        user.getRoles().add(defaultRole);
        repository.save(user);
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String name = authentication.getName();
            Optional<User> byEmail = repository.findByEmail(name);
            if(byEmail.isPresent())
             return  byEmail.get();
        }
        return null;
    }
}
    class UserCredentialsDtoMapper {
        static UserCredentialsDto map(User user) {
            String email = user.getEmail();
            String password = user.getPassword();
            Set<String> roles = user.getRoles()
                    .stream()
                    .map(UserRole::getName)
                    .collect(Collectors.toSet());
            return new UserCredentialsDto(email, password, roles);
        }
    }

