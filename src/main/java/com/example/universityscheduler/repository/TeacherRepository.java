package com.example.universityscheduler.repository;

import com.example.universityscheduler.domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface TeacherRepository extends MongoRepository<Teacher, UUID> {
}
