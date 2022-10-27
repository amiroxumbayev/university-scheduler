package com.example.universityscheduler.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@Document
public class Schedule {

    @Id
    private UUID id;
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
