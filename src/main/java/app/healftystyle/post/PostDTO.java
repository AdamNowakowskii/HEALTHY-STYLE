package app.healftystyle.post;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PostDTO {
    @NotNull
    private Long id;
    @NotEmpty
    private String title;
    private LocalDateTime dateAdded;
    @NotEmpty
    private String description;
    @NotEmpty
    private int upVotes;
    @NotEmpty
    private int downVotes;
    @NotEmpty
    private String urlLink;
    @NotEmpty
    private int countVotes;

}
