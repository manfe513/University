package com.example.drugs.controller;

import com.example.drugs.model.*;
import com.example.drugs.service.CourseService;
import com.example.drugs.service.DrugService;
import com.example.drugs.service.DrugTypeService;
import com.example.drugs.service.UseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    DrugService drugService;

    @Autowired
    DrugTypeService drugTypeService;

    @Autowired
    UseTypeService useTypeService;


    @GetMapping("/addCourse")
    public String addCourse(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("addCourseModel", new AddCourseModel());
        model.addAttribute("drugs", drugService.getAll());
        model.addAttribute("useTypes", useTypeService.getAll());
        model.addAttribute("message", message);

        return "AddCourse";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(AddCourseModel addCourseModel, RedirectAttributes redirectAttributes) {

        Course course = new Course(
                addCourseModel.getDrugId(),
                addCourseModel.getUseTypeId(),
                addCourseModel.getDateStart(),
                addCourseModel.getDateEnd(),
                addCourseModel.getTime()
        );

        if (courseService.saveOrUpdate(course)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/main";
        }

        redirectAttributes.addFlashAttribute("message", "save_error");
        return "redirect:/addCourse";
    }

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
