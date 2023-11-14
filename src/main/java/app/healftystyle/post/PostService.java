package app.healftystyle.post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import app.healftystyle.post.vote.Vote;
import app.healftystyle.post.vote.VoteDto;
import app.healftystyle.post.vote.VoteRepository;
import app.healftystyle.user.User;
import app.healftystyle.user.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;
    private final VoteRepository voteRepository;

    public List<PostDTO> findAlL() {
        return postRepository.findAll().stream().map(PostDtoMapper::map).collect(Collectors.toList());
    }


    public void saveNewPost(AddPostDTO newPost) {
        int DEFAULT_VALUE_VOTE = 0;
        Posts posts = new Posts(
                newPost.getTitle(),
                LocalDateTime.now(),
                newPost.getDescription(),
                DEFAULT_VALUE_VOTE,
                DEFAULT_VALUE_VOTE,
                newPost.getUrlLink()
        );
        postRepository.save(posts);
    }


    public void voteUp(Long id) {
        Optional<Posts> byId = postRepository.findById(id);
        User currentUser = userService.getCurrentUser();
        Optional<Vote> byPostId = voteRepository.findByPostIdAndUserId(id,currentUser.getId());
        if(byPostId.isEmpty()){
            Vote vote = new Vote(currentUser.getId(), id, true);
            voteRepository.save(vote);
            createPostDetails(byId,1);
        }
        if (byPostId.isPresent()) {
            if (byPostId.get().getUserId().equals(currentUser.getId()) && byPostId.get().getVoted().equals(false)) {
                Vote byUserId = voteRepository.findByUserIdAndPostId(currentUser.getId(),id);
               byUserId.setVoted(true);
               voteRepository.save(byUserId);
                createPostDetails(byId,1);
            }
        }
    }
    @Transactional
    public void voteDown(Long id) {
        Optional<Posts> byId = postRepository.findById(id);
        User currentUser = userService.getCurrentUser();
        Optional<Vote> byPostId = voteRepository.findByPostIdAndUserId(id,currentUser.getId());
        if(byPostId.isEmpty()){
            Vote vote = new Vote(currentUser.getId(), id, false);
            createPostDetails(byId,-1);
            voteRepository.save(vote);
        }
        if (byPostId.isPresent()) {
            if (byPostId.get().getUserId().equals(currentUser.getId()) && byPostId.get().getVoted().equals(true)) {
                Vote byUserId = voteRepository.findByUserIdAndPostId(currentUser.getId(), id);
                byUserId.setVoted(false);
                voteRepository.save(byUserId);
                createPostDetails(byId,-1);
            }
        }
    }

    @Transactional
    public void createPostDetails(Optional<Posts> byId, int voteValue) {
        if (byId.isPresent()) {
            int upVotes = byId.get().getUpVotes();
            Posts voteUpdate = new Posts(
                    byId.get().getPostId(),
                    byId.get().getTitle(),
                    byId.get().getDateAdded(),
                    byId.get().getDescription(),
                    upVotes + voteValue,
                    byId.get().getDownVotes(),
                    byId.get().getUrlLink());
            postRepository.save(voteUpdate);
        }
    }

    static class PostDtoMapper {
        static PostDTO map(Posts posts) {
            return new PostDTO(
                    posts.getPostId(),
                    posts.getTitle(),
                    posts.getDateAdded(),
                    posts.getDescription(),
                    posts.getUpVotes(),
                    posts.getDownVotes(),
                    posts.getUrlLink(),
                    posts.getUpVotes() - posts.getDownVotes()
            );
        }
    }

    static class VoteEntityMapper {
        static Vote map(VoteDto vote) {
            return new Vote(
                    vote.getPostId(),
                    vote.getUserId(),
                    vote.getVoted()
            );
        }
    }
}
