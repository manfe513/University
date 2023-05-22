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
import org.springframework.web.bind.annotation.PathVariable;
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
            redirectAttributes.addFlashAttribute("message", "save_success");
            return "redirect:/main";
        }

        redirectAttributes.addFlashAttribute("message", "save_error");
        return "redirect:/addCourse";
    }

    @GetMapping("/editCourse/{id}")
    public String editCourse(@PathVariable Long id, Model model) {
        AddCourseModel addCourseModel = new AddCourseModel();
        Course course = courseService.getById(id);

        addCourseModel.setCourseId(course.getId());
        addCourseModel.setDrugId(course.getIdDrug());

        model.addAttribute("addCourseModel", addCourseModel);
        model.addAttribute("drugs", drugService.getAll());
        model.addAttribute("useTypes", useTypeService.getAll());

        return "EditCourse";
    }

    @PostMapping("/editSaveCourse")
    public String editSaveAnime(AddCourseModel addCourseModel, RedirectAttributes redirectAttributes) {
        Course course = courseService.getById(addCourseModel.getCourseId());

        course.setIdDrug(addCourseModel.getDrugId());
        course.setIdUseType(addCourseModel.getUseTypeId());
        course.setDate_start(addCourseModel.getDateStart());
        course.setDate_end(addCourseModel.getDateEnd());
        course.setTime(addCourseModel.getTime());

        if (courseService.saveOrUpdate(course)) {
            redirectAttributes.addFlashAttribute("message", "edit_success");
            return "redirect:/main";
        }

        redirectAttributes.addFlashAttribute("message", "edit_error");
        return "redirect:/editCourse/" + course.getId();
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteCourse(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes
    ) {

        if (courseService.deleteById(id)) {
            redirectAttributes.addFlashAttribute("message", "delete_success");

        } else {
            redirectAttributes.addFlashAttribute("message", "delete_error");
        }

        return "redirect:/main";
    }
}
