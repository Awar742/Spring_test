package com.proba.blog;

import com.proba.blog.Repo.PostRepository;
import com.proba.blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class lotController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/lot/{id}")
    public String Lot (@PathVariable("id") int id, Model model){
        Iterable<Post> posts= postRepository.findAll();
        model.addAttribute("posts", posts);
        model.addAttribute("id_lot", id);
        return "lot";
    }
}
