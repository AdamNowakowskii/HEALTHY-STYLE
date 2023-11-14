package app.healftystyle.post;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddPostDTO {
    @NotBlank

    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String urlLink;
}
