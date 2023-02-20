package com.cantvas.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import com.cantvas.api.repositories.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/courses", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class CourseController {

    @Autowired
    CourseRepository courseRepo;

    @GetMapping
    public String getCourseInfo(@Param(value = "id") Long courseId) {
        return courseRepo.findById(courseId)
                .map(course -> course.getDescription())
                .orElseThrow();
    }
}
