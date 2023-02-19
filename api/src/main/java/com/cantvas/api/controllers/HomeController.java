package com.cantvas.api.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;


import java.util.List;
import java.util.ArrayList;

import com.cantvas.api.repositories.CourseRepository;
import com.cantvas.api.models.Course;

@Controller("/")
public class HomeController {

    @Autowired
    CourseRepository courseRepository;

    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @ModelAttribute
    public void allCoursesToModel(Model model) {
        List<Course> courses = new ArrayList<>();
        getAllCourses().forEach(course -> courses.add(course));
        model.addAttribute("courses", courses);
    }

    @GetMapping("courses")
    public String courses() {
        return "courses";
    }

    @GetMapping("home")
    public String home() {
        return "home";
    }

}
