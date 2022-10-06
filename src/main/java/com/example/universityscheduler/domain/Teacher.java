package com.example.universityscheduler.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Data
public class Teacher {

    private UUID id;
    private String name;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Schedule> schedules;

}
