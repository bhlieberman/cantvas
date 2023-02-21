package com.cantvas.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;

import com.cantvas.api.models.Student;
import com.cantvas.api.repositories.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    private Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentInfo(@PathVariable(value = "id") final Long courseId) {
        return studentRepository.findById(courseId).get();
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
