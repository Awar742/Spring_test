package com.proba.blog;

import com.proba.blog.models.Authorities;
import com.proba.blog.repo.AuthorityRepository;
import com.proba.blog.repo.UserRepository;
import com.proba.blog.dto.UserDto;
import com.proba.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/login")
    public String login ( Model model){
        Iterable<User> users= userRepository.findAll();

        model.addAttribute("users", users);
        return "login";
    }

    @PostMapping("/login")
    public String postlogin(@ModelAttribute("user") User user , BindingResult result){
        if (result.hasErrors()) {
            return "registration";
        }

        return "/greeting";
    }

    @GetMapping("/regist")
    public String regist( Model model){
        UserDto user= new UserDto();

        model.addAttribute("user", user);
        return "regist";
    }

    @PostMapping("/regist")
    public String postregist(@ModelAttribute("user") UserDto userDto , BindingResult result){
        if (result.hasErrors()) {
            return "registration";
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPhone(userDto.getPhone());
        user.setEnabled(true);
        userRepository.save(user);
        Authorities authorities = new Authorities();
        authorities.setUsername(authorities.getUsername());
        authorities.setAuthority("ROLE_USER");
        authorityRepository.save(authorities);



        return "/greeting";
    }

    @GetMapping("/userInfo")
    public String userInfo(Principal principal,Model model){

        Authentication authentication = (Authentication) principal;
        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
        final String username = user.getUsername();

        User user1= userRepository.findById(username).get();
        model.addAttribute("user", user1);
        return ("userInfo");


    }


}
