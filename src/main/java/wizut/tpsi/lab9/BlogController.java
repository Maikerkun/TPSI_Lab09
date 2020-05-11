package wizut.tpsi.lab9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
public class BlogController {
    @Autowired
    private BlogRepository repo;

    @RequestMapping("/")
    public String getPosts(Model model) throws SQLException
    {
        model.addAttribute("allPosts", repo.getAllPosts());
        return "index";
    }

    @PostMapping("/newpost")
    public String newPost(BlogPost post) throws SQLException {
        repo.createPost(post);
        return "redirect:/";
    }

    @PostMapping("/removepost")
    public String removePost(BlogPost post) throws SQLException {
        repo.removePost(post);
        return "redirect:/";
    }
}
