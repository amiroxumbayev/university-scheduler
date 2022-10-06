package com.example.universityscheduler.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Data
public class Group {

    private UUID id;
    private String title;
    private Integer course;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private EducationalProgram educationalProgram;
}
