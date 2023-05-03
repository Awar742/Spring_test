package com.proba.blog;

import com.proba.blog.Repo.PostRepository;
import com.proba.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class registController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/regist")
    public String regist (Model model){
        Iterable<Post> posts= postRepository.findAll();
        model.addAttribute("posts", posts);
        return "regist";
    }
}
