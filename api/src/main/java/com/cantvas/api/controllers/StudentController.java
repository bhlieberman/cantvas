package com.cantvas.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;

import com.cantvas.api.models.Student;
import com.cantvas.api.repositories.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    StudentRepository studentRepository;

    private Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @ModelAttribute
    public void modelAllStudents(Model model) {
        List<Student> students = new ArrayList<>();
        getAllStudents().forEach(student -> students.add(student));
        model.addAttribute("studentInfo", students);
    }

    @ModelAttribute(name = "studentCons")
    public Student student(final String name, final String email) {
        return new Student(name, email);
    }

    @GetMapping
    public String allStudents() {
        log.info("retrieving student view");
        return "students";
    }
}
