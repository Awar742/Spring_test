package com.proba.blog;

import com.proba.blog.Repo.PostRepository;
import com.proba.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class secondController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/second/{type}")
    public String Second (@PathVariable("type") String type , Model model){
        Iterable<Post> posts= postRepository.getByType(type);
        model.addAttribute("posts", posts);
        return "second";
    }
}
