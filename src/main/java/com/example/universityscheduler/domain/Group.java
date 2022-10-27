package com.example.universityscheduler.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@RequiredArgsConstructor
@Document
public class Group {
    @Id
    private UUID id;
    private String title;
    private Integer course;
}
