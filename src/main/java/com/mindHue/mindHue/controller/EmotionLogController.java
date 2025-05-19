package com.mindhue.mindhue.controller;

import com.mindhue.mindhue.model.EmotionLog;
import com.mindhue.mindhue.service.EmotionLogService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// Removed duplicate class definition

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/emotion-logs")
public class EmotionLogController {

    private final EmotionLogService service;

    public EmotionLogController(EmotionLogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> createEmotionLog(@RequestBody EmotionLog log) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            String jsonString = mapper.writeValueAsString(log);
            System.out.println("Received emotion log: " + jsonString);
        } catch (Exception e) {
            System.out.println("Error converting EmotionLog to JSON: " + e.getMessage());
        }
        return service.createEmotionLog(log);
    }

    @GetMapping
    public ResponseEntity<Object> getAllEmotionLogs() {
        return service.getAllEmotionLogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmotionLog> getEmotionLogById(@PathVariable int id) {
        return service.getEmotionLogById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmotionLog> updateEmotionLog(@PathVariable int id, @RequestBody EmotionLog log) {
        return service.updateEmotionLog(id, log);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmotionLog(@PathVariable int id) {
        return service.deleteEmotionLog(id);
    }
}