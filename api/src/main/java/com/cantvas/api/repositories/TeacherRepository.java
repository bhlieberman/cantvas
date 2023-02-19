package com.cantvas.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cantvas.api.models.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}
