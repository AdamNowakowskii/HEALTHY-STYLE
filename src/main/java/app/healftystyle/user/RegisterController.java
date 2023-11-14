package app.healftystyle.user;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import app.healftystyle.config.UserRegistrationDTO;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class RegisterController {
    UserService userService;

    @GetMapping("/register")
    public String registrationForm(Model model) {
        UserRegistrationDTO userRegistration = new UserRegistrationDTO();
        model.addAttribute("userRegistration", userRegistration);
        return "register_form";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistration, BindingResult result, Model model) {
        Optional<UserCredentialsDto> credentialsByEmail = userService.findCredentialsByEmail(userRegistration.getEmail());
        if (credentialsByEmail.isPresent())
            return "redirect:/register?emailFail";
        if (userRegistration.getPassword().length() < 8)
            return "redirect:/register?passwordFail";
        userService.registerUserWithDefaultRole(userRegistration);
        return "redirect:/";
    }
}
