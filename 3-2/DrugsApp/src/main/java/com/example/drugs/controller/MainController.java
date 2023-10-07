package com.example.drugs.controller;

import com.example.drugs.model.*;
import com.example.drugs.service.CourseService;
import com.example.drugs.service.DrugService;
import com.example.drugs.service.DrugTypeService;
import com.example.drugs.service.UseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    CourseService courseService;

    @Autowired
    DrugService drugService;

    @Autowired
    DrugTypeService drugTypeService;

    @Autowired
    UseTypeService useTypeService;


    @GetMapping({"/", "/main"})
    public String viewMainPage(
            @ModelAttribute("message") String message,
            @CookieValue(name = "user_id", required = false) Long userId,
            Model model
    ) {
        List<Course> courses = courseService.getAll();
        ArrayList<CourseInfo> courseInfos = new ArrayList<>();

        for (Course course : courses) {
            Drug drug = drugService.getById(course.getIdDrug());
            DrugType drugType = drugTypeService.getById(drug.getIdDrugType());
            UseType useType = useTypeService.getById(course.getIdUseType());

            courseInfos.add(new CourseInfo(
                    course,
                    drug,
                    drugType,
                    useType
            ));
        }

        model.addAttribute("courseInfos", courseInfos);
        model.addAttribute("message", message);

        return "Main";
    }
}
