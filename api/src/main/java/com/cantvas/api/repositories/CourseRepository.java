package com.cantvas.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cantvas.api.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    
}
