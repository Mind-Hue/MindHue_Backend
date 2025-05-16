package com.mindhue.mindhue.service;

import com.mindhue.mindhue.model.Reflection;
import com.mindhue.mindhue.repository.ReflectionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReflectionService {

    private final ReflectionRepository repository;

    public ReflectionService(ReflectionRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Object> createReflection(Reflection reflection) {
        repository.save(reflection);
        return ResponseEntity.ok(reflection);
    }

    public ResponseEntity<Object> getReflectionsByLogId(int logId) {
        return ResponseEntity.ok(repository.findAll().stream()
                .filter(reflection -> reflection.getEmotionLogId() == logId));
    }

    public Optional<Reflection> getReflectionById(int id) {
        return repository.findById(id);
    }

    public ResponseEntity<Reflection> updateReflection(int id, Reflection updatedReflection) {
        return repository.findById(id).map(reflection -> {
            reflection.setAnswers(updatedReflection.getAnswers());
            reflection.setExtraNote(updatedReflection.getExtraNote());
            repository.save(reflection);
            return ResponseEntity.ok(reflection);
        }).orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> deleteReflection(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok("Reflection deleted");
        }
        return ResponseEntity.notFound().build();
    }
}