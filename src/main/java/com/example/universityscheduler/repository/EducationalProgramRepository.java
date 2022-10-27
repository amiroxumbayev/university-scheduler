package com.example.universityscheduler.repository;

import com.example.universityscheduler.domain.EducationalProgram;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EducationalProgramRepository extends MongoRepository<EducationalProgram, UUID> {
}
