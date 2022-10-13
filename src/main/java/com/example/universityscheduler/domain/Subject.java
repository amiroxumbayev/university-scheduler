package com.example.universityscheduler.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Data
public class Subject {

    private UUID id;
    private String title;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<EducationalProgram> educationalPrograms;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Schedule> schedules;
}
