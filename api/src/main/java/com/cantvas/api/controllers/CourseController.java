package com.cantvas.api.controllers;

import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

import com.cantvas.api.repositories.*;
import com.cantvas.api.models.Course;
import com.cantvas.api.models.Student;

@Slf4j
@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost://localhost:3000/details/**"})
public class CourseController {

    @Autowired
    CourseRepository courseRepo;

    @GetMapping("/info")
    public Course getCourseInfo(@RequestParam Long courseId) {
        Optional<Course> course_desc = courseRepo.findById(courseId);
        return course_desc.get();
    }

    @GetMapping("/info/enrolled")
    public List<Student> getEnrolledStudents(@RequestParam Long courseId) {
        return courseRepo.findById(courseId).get().getEnrolled();
    }

    @GetMapping("/info/enrolled/{id}")
    public List<Student> getEnrolledStudentById(@PathVariable(value = "id") Long courseId) {
        return courseRepo.findById(courseId).get().getEnrolled();
    }

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        courseRepo.findAll().forEach(course -> courses.add(course));
        return courses;
    }

    @PutMapping("/enroll")
    public Student enrollStudent(@RequestParam Long courseId, @RequestBody Student student) {
        Optional<Course> updatedCourse = courseRepo.findById(courseId).flatMap(_course -> {
            _course.enrollStudent(student);
            return Optional.of(_course);
        });
        courseRepo.save(updatedCourse.get());
        return student;
    }

    @PostMapping(path = "/new", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Course addCourse(@RequestBody Course course) {
        log.info("received course " + course.getName());
        return courseRepo.save(course);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourse(@RequestBody final Course newCourse) {
        Optional<Course> updatedCourse = courseRepo.findById(newCourse.getId()).flatMap(course -> {
            try {
                course.setBeginDate(newCourse.getBeginDate());
                course.setEndDate(newCourse.getEndDate());
            } catch (Exception e) {
                log.error(e.getMessage());
                return Optional.empty();
            }
            return Optional.of(course);
        });
        courseRepo.save(updatedCourse.get());
    }
}
