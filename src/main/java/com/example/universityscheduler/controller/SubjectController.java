package com.example.universityscheduler.controller;

import com.example.universityscheduler.domain.dto.SubjectDTO;
import com.example.universityscheduler.service.SubjectService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;
    private final KafkaTemplate<UUID, SubjectDTO> kafkaTemplate;

    public SubjectController(SubjectService subjectService, KafkaTemplate<UUID, SubjectDTO> kafkaTemplate) {
        this.subjectService = subjectService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/add")
    public ResponseEntity<SubjectDTO> save(@RequestBody SubjectDTO subjectDTO) {
        try {
            SubjectDTO savedSubjectDto = subjectService.save(subjectDTO);
            URI location = UriComponentsBuilder.fromPath("/subjects/id").buildAndExpand(savedSubjectDto.getId()).toUri();
            return ResponseEntity.created(location).body(savedSubjectDto);
        } catch(Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<SubjectDTO> findById(@PathVariable UUID id) {
        try {
            SubjectDTO subjectDto = subjectService.findById(id);
            return ResponseEntity.ok(subjectDto);
        } catch(Exception e) {
            return ResponseEntity.notFound().header("Message",e.getMessage()).build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<SubjectDTO>> findAll(Pageable pageable) {
        Page<SubjectDTO> subjects = subjectService.findAll(pageable);
        return ResponseEntity.ok(subjects);
    }

    @PostMapping(value = "/subject", consumes = "multipart/form-data")
    public ResponseEntity<Object> sendEmail(@RequestBody SubjectDTO subjectDTO) {
        try {
            ListenableFuture<SendResult<UUID, SubjectDTO>> future = kafkaTemplate.send("subject", subjectDTO.getId() ,subjectDTO);
            future.addCallback(System.out::println, System.err::println);
            kafkaTemplate.flush();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getStackTrace());
        }
    }

    @KafkaListener(topics = "subject")
    public void messageListener(ConsumerRecord<UUID, SubjectDTO> record) {
        System.err.println(record.value());
    }
}
