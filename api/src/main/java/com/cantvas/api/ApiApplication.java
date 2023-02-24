package com.cantvas.api;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cantvas.api.repositories.CourseRepository;
import com.cantvas.api.repositories.StudentRepository;
import com.cantvas.api.repositories.TeacherRepository;
import com.cantvas.api.models.*;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	CommandLineRunner dataLoader(CourseRepository courseRepository, StudentRepository studentRepository,
	TeacherRepository teacherRepository) {
		return args -> {
			courseRepository.saveAll(List.of(new Course("Java 401", "Advanced Java course with Spring and Android", null, null),
			new Course("JavaScript 401", "Advanced JavaScript course going deep into React and Node.js", null, null),
			new Course("JavaScript 201", "Introductory JavaScript", null, null)));

			studentRepository.saveAll(List.of(new Student("Ben", "bhlieberman93@gmail.com"), new Student("Mehtab", "mriar@gmail.com"), new Student("Joe", "jrutkin@gmail.com")));

			teacherRepository.saveAll(List.of(new Teacher("Alex", "awhite@codefellows.com"), new Teacher("David", "dsouther@codefellows.com"), new Teacher("Roger", "rreyes@codefellows.com")));
		};
	}
}
