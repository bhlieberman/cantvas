package com.cantvas.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.cantvas.api.repositories.CourseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cantvas.api.models.Course;

import java.util.List;
import java.util.ArrayList;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ApiApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class CourseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    CourseRepository courseRepo;

    @Test
    public void testCourseDoesNotExist() throws Exception {
        mockMvc.perform(get("/api/courses/info?courseId=4"))
                .andExpect(status().is(404));
    }

    @Test
    public void testCourseDoesExist() throws Exception {
        courseRepo.saveAll(List.of(new Course("Java 401", "Advanced Java course with Spring and Android", null, null),
                new Course("JavaScript 401", "Advanced JavaScript course going deep into React and Node.js", null,
                        null),
                new Course("JavaScript 201", "Introductory JavaScript", null, null)));
        mockMvc.perform(get("/api/courses/all"))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCanAddCourse() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(
                new Course("Java 401", "Advanced Java course with Spring and Android", new ArrayList<>(),
                        new ArrayList<>()));
        mockMvc.perform(post("/api/courses/new")
                .contentType("application/json")
                .content(json)
                .characterEncoding("utf-8")).andExpect(status().is2xxSuccessful());
    }
}
