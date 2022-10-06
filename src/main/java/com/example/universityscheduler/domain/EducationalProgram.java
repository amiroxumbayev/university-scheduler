package com.example.universityscheduler.domain;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class EducationalProgram {

    private UUID id;
    private String title;
    private boolean elective;
    private List<Subject> subjects;
    private List<Group> groups;
}
