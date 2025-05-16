package com.mindhue.mindhue.service;

import com.mindhue.mindhue.model.EmotionLog;
import com.mindhue.mindhue.repository.EmotionLogRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmotionLogService {

    private final EmotionLogRepository repository;

    public EmotionLogService(EmotionLogRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Object> createEmotionLog(EmotionLog log) {
        repository.save(log);
        return ResponseEntity.ok(log);
    }

    public ResponseEntity<Object> getAllEmotionLogs() {
        return ResponseEntity.ok(repository.findAll());
    }

    public Optional<EmotionLog> getEmotionLogById(int id) {
        return repository.findById(id);
    }

    public ResponseEntity<EmotionLog> updateEmotionLog(int id, EmotionLog updatedLog) {
        return repository.findById(id).map(log -> {
            log.setEmotionTypeId(updatedLog.getEmotionTypeId());
            log.setExerciseId(updatedLog.getExerciseId());
            log.setIntensity(updatedLog.getIntensity());
            log.setUserName(updatedLog.getUserName());
            repository.save(log);
            return ResponseEntity.ok(log);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteEmotionLog(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok("EmotionLog deleted");
        }
        return ResponseEntity.notFound().build();
    }
}