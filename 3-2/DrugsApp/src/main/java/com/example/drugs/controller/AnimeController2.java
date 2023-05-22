package com.example.drugs.controller;

import com.example.drugs.model.Anime;
import com.example.drugs.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AnimeController2 {

    @Autowired
    AnimeService animeService;


//    @GetMapping({"/", "/main"})
//    public String viewMainPage(
//            @ModelAttribute("message") String message,
//            @CookieValue(name = "user_hash") String userHash,
//            Model model
//    ) {
//        model.addAttribute("animeList", ${cookie['name']});
//        model.addAttribute("animeList", animeService.getAllAnime());
//        model.addAttribute("message", message);
//
//        return "ViewAnimeList";
//    }
//
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
//        if (animeService.saveOrUpdateAnime(anime)) {
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
//        model.addAttribute("anime", animeService.getAnimeById(id));
//
//        return "EditAnime";
//    }
//
//    @PostMapping("/editSaveAnime")
//    public String editSaveAnime(Anime anime, RedirectAttributes redirectAttributes) {
//        if (animeService.saveOrUpdateAnime(anime)) {
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
//        if (animeService.deleteAnime(id)) {
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
//        model.addAttribute("anime", animeService.getAnimeById(id));
//
//        return "ReviewsAnime";
//    }
//
//    @PostMapping("/reviewSaveAnime")
//    public String reviewSaveAnime(Anime anime, RedirectAttributes redirectAttributes) {
//        if (animeService.saveOrUpdateAnime(anime)) {
//            redirectAttributes.addFlashAttribute("message", "Save Success");
//            return "redirect:/viewAnimeList";
//        }
//
//        redirectAttributes.addFlashAttribute("message", "Save Failure");
//        return "redirect:/viewAnime/" + anime.getId();
//    }
}
