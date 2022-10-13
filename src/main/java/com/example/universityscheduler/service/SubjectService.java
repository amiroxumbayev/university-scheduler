package com.example.universityscheduler.service;

import com.example.universityscheduler.domain.dto.SubjectDTO;

import java.util.UUID;

public interface SubjectService {

    SubjectDTO save(SubjectDTO subjectDTO);

    SubjectDTO findById(UUID id);
}
