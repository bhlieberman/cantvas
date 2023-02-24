package com.cantvas.api.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public final class Course {
    final String name;
    final String description;

    @Setter
    LocalDate beginDate;
    
    @Setter
    LocalDate endDate;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    final List<Student> enrolled;

    @OneToMany(cascade = CascadeType.ALL)
    final List<Teacher> instructor;

    public final boolean enrollStudent(final Student student) {
        return enrolled.add(student);
    }
}
