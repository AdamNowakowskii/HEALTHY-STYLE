package app.healftystyle.user.PasswordChanger;


import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PasswordChangerController {
//    UserService userService;
//    EmailService emailService;
//    UserRepository userRepository;
//    PasswordResetTokenService passwordResetTokenService;
//    private final static String SITE_NAME = "http://localhost:8080";

//    @GetMapping("/send/email")
//    public String passwordEmailSender(@RequestParam String email) {
//        String token = UUID.randomUUID().toString();
//        PasswordResetTokenDTO passwordResetTokenDTO = new PasswordResetTokenDTO(token, userRepository.findUserByEmail(email), LocalDateTime.now().plusMinutes(15));
//        passwordResetTokenService.save(passwordResetTokenDTO);
//        emailService.sendSimpleMail(new EmailDetails(email, "Ck the link to change password  " + "\n" + SITE_NAME + "/change/password/?token=" + token, "Password Change", ""));
//        return "redirect:/password/change/form";
//    }
}
