package com.cantvas.api.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cantvas.api.models.Course;

import jakarta.transaction.Transactional;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findByBeginDate(LocalDate beginDate);
    List<Course> findByEndDate(LocalDate endDate);

    @Transactional
    @Modifying
    @Query(value = "update Course c set c.name = :name where c.id = :courseId")
    void updateCourse(@Param("name") String courseName, Course course, @Param("courseId") Long courseId);
}
