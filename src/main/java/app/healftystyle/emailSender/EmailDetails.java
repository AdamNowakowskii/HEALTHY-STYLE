package app.healftystyle.emailSender;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmailDetails {
    @NotBlank
    private String recipient;
    @NotBlank
    private String msgBody;
    @NotBlank
    private String subject;
    @NotBlank
    private String attachment;
}