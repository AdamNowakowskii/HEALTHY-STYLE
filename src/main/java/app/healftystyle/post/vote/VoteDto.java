package app.healftystyle.post.vote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class VoteDto {
    private Long userId;
    private Long postId;
    private Boolean voted;

}
