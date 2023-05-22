package com.example.drugs.controller;

import com.example.drugs.model.User;
import com.example.drugs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;


    @GetMapping({"/registration"})
    public String viewMainPage(
            @ModelAttribute("message") String message,
            @CookieValue(name = "user_id", required = false) Long userId,
            Model model
    ) {
//        User user = userId != null ? userService.getById(userId) : null;
        User user = userService.getById(0l) ;
        model.addAttribute("user", user);
//        model.addAttribute("animeList", userService.getAllAnime());
        model.addAttribute("message", message);

        return "Main";
    }
}
