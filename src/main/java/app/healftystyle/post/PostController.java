package app.healftystyle.post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/blog")
    public String allPost(Model model){
        model.addAttribute("post", postService.findAlL());
        return "blog";
    }

    @Transactional
    @GetMapping("/logged/voteUp/{id}")
    public String voteUp (@PathVariable("id") Long id){
        postService.voteUp(id);
        return  "redirect:/blog";
    }
    @Transactional
    @GetMapping("/logged/voteDown/{id}")
    public String voteDown (@PathVariable("id") Long id){
        postService.voteDown(id);
        return "redirect:/blog";
    }

    @PostMapping("/admin/newPost")
    public String addPost(AddPostDTO post){
            postService.saveNewPost(post);
        return "redirect:/";
    }
    @GetMapping("/admin/newPost")
    public String newPost(Model model){
        AddPostDTO addPostDTO = new AddPostDTO();
        model.addAttribute("addPostDTO",addPostDTO);
        return "newPost";
    }
}
