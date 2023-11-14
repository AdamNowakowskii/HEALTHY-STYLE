package app.healftystyle.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.healftystyle.user.UserCredentialsDto;
import app.healftystyle.user.UserService;
import lombok.AllArgsConstructor;

@Service
@Configuration
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            return userService.findCredentialsByEmail(username)
                    .map(this::createUserDetails)
                    .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", username))
                    );

        } catch (UsernameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private UserDetails createUserDetails(UserCredentialsDto credentials) {
        return User.builder()
                .username(credentials.getEmail())
                .password(credentials.getPassword())
                .roles(credentials.getRoles().toArray(String[]::new))
                .build();
    }

}
