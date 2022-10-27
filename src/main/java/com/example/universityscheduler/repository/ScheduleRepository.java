package com.example.universityscheduler.repository;

import com.example.universityscheduler.domain.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ScheduleRepository extends MongoRepository<Schedule, UUID> {
}
