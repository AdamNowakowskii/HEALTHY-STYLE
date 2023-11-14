package app.healftystyle.post;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long postId;
    @NotBlank
    private String title;
    private LocalDateTime dateAdded;
    @NotBlank
    private String description;
    @NotNull
    private int upVotes;
    @NotNull
    private int downVotes;
    @NotEmpty
    private String urlLink;

    public Posts(String title, LocalDateTime dateAdded, String description, int upVotes, int downVotes, String urlLink) {
        this.title = title;
        this.dateAdded = dateAdded;
        this.description = description;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.urlLink = urlLink;
    }
}
