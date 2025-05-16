package com.mindhue.mindhue.controller;

import com.mindhue.mindhue.model.EmotionLog;
import com.mindhue.mindhue.service.EmotionLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/emotion-logs")
public class EmotionLogController {

    private final EmotionLogService service;

    public EmotionLogController(EmotionLogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> createEmotionLog(@Valid @RequestBody EmotionLog log) {
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
    public ResponseEntity<EmotionLog> updateEmotionLog(@PathVariable int id, @Valid @RequestBody EmotionLog log) {
        return service.updateEmotionLog(id, log);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmotionLog(@PathVariable int id) {
        return service.deleteEmotionLog(id);
    }
}