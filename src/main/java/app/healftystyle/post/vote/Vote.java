package app.healftystyle.post.vote;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long userId;
    private Long postId;
    private Boolean voted;

    public Vote(Long userId, Long postId, Boolean voted) {
        this.userId = userId;
        this.postId = postId;
        this.voted = voted;
    }
}

