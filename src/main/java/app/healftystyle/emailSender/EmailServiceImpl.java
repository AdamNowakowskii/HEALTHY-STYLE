package app.healftystyle.emailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public String sendSimpleMail(EmailDetails details) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@baeldung.com");
        message.setTo(details.getRecipient());
        message.setSubject(details.getSubject());
        message.setText(details.getMsgBody());
        emailSender.send(message);
        return "send";
    }

    @Override
    public String sendMailWithAttachment(EmailDetails details) {
        return null;
    }
}
