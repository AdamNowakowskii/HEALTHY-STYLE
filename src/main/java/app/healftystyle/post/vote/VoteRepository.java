package app.healftystyle.post.vote;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote,Long> {
    Optional<Vote> findByPostIdAndUserId(Long postId, Long userId);
    Vote findByUserIdAndPostId(Long id, Long postId);
}
