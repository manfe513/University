package com.example.drugs.controller;

import com.example.drugs.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class MainController {

    @Autowired
    CourseService courseService;


    @GetMapping({"/", "/main"})
    public String viewMainPage(
            @ModelAttribute("message") String message,
            @CookieValue(name = "user_id", required = false) Long userId,
            Model model
    ) {
        model.addAttribute("courses", courseService.getAll());
        model.addAttribute("message", message);

        return "Main";
    }

//    @GetMapping("/addAnime")
//    public String addAnime(@ModelAttribute("message") String message, Model model) {
//        model.addAttribute("anime", new Anime());
//        model.addAttribute("message", message);
//
//        return "AddAnime";
//    }
//
//    @PostMapping("/saveAnime")
//    public String saveAnime(Anime anime, RedirectAttributes redirectAttributes) {
//        if (userService.saveOrUpdateAnime(anime)) {
//            redirectAttributes.addFlashAttribute("message", "Save Success");
//            return "redirect:/viewAnimeList";
//        }
//
//        redirectAttributes.addFlashAttribute("message", "Save Failure");
//        return "redirect:/addAnime";
//    }
//
//    @GetMapping("/editAnime/{id}")
//    public String editAnime(@PathVariable Long id, Model model) {
//        model.addAttribute("anime", userService.getAnimeById(id));
//
//        return "EditAnime";
//    }
//
//    @PostMapping("/editSaveAnime")
//    public String editSaveAnime(Anime anime, RedirectAttributes redirectAttributes) {
//        if (userService.saveOrUpdateAnime(anime)) {
//            redirectAttributes.addFlashAttribute("message", "Edit Success");
//            return "redirect:/viewAnimeList";
//        }
//
//        redirectAttributes.addFlashAttribute("message", "Edit Failure");
//        return "redirect:/editAnime/" + anime.getId();
//    }
//
//    @GetMapping("/deleteAnime/{id}")
//    public String deleteAnime(@PathVariable Long id, RedirectAttributes redirectAttributes) {
//        if (userService.deleteAnime(id)) {
//            redirectAttributes.addFlashAttribute("message", "Delete Success");
//        } else {
//            redirectAttributes.addFlashAttribute("message", "Delete Failure");
//        }
//
//        return "redirect:/viewAnimeList";
//    }
//
//    @GetMapping("/reviewAnime/{id}")
//    public String reviewAnime(@PathVariable Long id, Model model) {
//        model.addAttribute("anime", userService.getAnimeById(id));
//
//        return "ReviewsAnime";
//    }
//
//    @PostMapping("/reviewSaveAnime")
//    public String reviewSaveAnime(Anime anime, RedirectAttributes redirectAttributes) {
//        if (userService.saveOrUpdateAnime(anime)) {
//            redirectAttributes.addFlashAttribute("message", "Save Success");
//            return "redirect:/viewAnimeList";
//        }
//
//        redirectAttributes.addFlashAttribute("message", "Save Failure");
//        return "redirect:/viewAnime/" + anime.getId();
//    }
}
