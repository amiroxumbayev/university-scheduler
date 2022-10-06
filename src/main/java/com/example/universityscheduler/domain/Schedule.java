package com.example.universityscheduler.domain;

import lombok.Data;

import java.time.LocalTime;
import java.util.UUID;

@Data
public class Schedule {

    private UUID id;
    private Subject subject;
    private Teacher teacher;
    private Week week;
    private LocalTime startTime;
    private LocalTime endTime;

    public enum Week {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
}
