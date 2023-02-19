package com.cantvas.api.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.cantvas.api.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {}
