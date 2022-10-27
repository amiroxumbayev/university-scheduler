package com.example.universityscheduler.repository;

import com.example.universityscheduler.domain.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SubjectRepository extends MongoRepository<Subject, UUID> {
}
