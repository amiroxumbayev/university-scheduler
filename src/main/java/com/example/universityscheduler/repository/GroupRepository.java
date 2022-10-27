package com.example.universityscheduler.repository;

import com.example.universityscheduler.domain.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface GroupRepository extends MongoRepository<Group, UUID> {
}
