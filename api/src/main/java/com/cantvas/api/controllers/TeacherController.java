package com.cantvas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;
import java.util.ArrayList;

import com.cantvas.api.models.Teacher;
import com.cantvas.api.repositories.TeacherRepository;


@Slf4j
@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    private Iterable<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @ModelAttribute
    public void addTeachersToModel(Model model) {
        List<Teacher> teachers = new ArrayList<>();
        getAllTeachers().forEach(teacher -> teachers.add(teacher));
        model.addAttribute("teachersInfo", teachers);
    }

    @GetMapping
    public String allTeachers() {
        log.info("retrieving teacher view");
        return "teachers";
    }
}
