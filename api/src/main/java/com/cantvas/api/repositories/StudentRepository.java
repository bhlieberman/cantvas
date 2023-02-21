package com.cantvas.api.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cantvas.api.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {}
