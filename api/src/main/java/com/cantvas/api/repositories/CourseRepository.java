package com.cantvas.api.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cantvas.api.models.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findByBeginDate(LocalDate beginDate);
    List<Course> findByEndDate(LocalDate endDate);
}
