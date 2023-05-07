package com.proba.blog;

import com.proba.blog.Repo.PostRepository;
import com.proba.blog.Repo.UserRepository;
import com.proba.blog.models.Post;
import com.proba.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;

@Controller
public class registController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/regist")
    public String Regist ( Model model){
        Iterable<User> users= userRepository.findAll();

        model.addAttribute("users", users);
        return "regist";
    }

    @PostMapping("/regist")
    public String Postreg(@ModelAttribute("user") User user , BindingResult result){
        if (result.hasErrors()) {
            return "registration";
        }

        return "/greeting";
    }

}
