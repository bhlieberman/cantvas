package com.cantvas.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    final String name;

    LocalDate dueDate;

    Long grade;

    @ManyToOne
    Student student;
}
