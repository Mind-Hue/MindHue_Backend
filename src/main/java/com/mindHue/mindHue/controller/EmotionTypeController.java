package com.mindhue.mindhue.controller;

import com.mindhue.mindhue.model.EmotionType;
import com.mindhue.mindhue.repository.EmotionTypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/emotion-types")
public class EmotionTypeController {

    private final EmotionTypeRepository repository;

    public EmotionTypeController(EmotionTypeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Object> getAllEmotionTypes() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmotionTypeById(@PathVariable int id) {
        return ResponseEntity.ok(repository.findById(id)
            .map(emotionType -> ResponseEntity.ok(emotionType))
            .orElse(ResponseEntity.notFound().build()));
    }

    @PostMapping
    public ResponseEntity<Object> createEmotionType(@Valid @RequestBody EmotionType emotionType) {
        EmotionType savedEmotionType = repository.save(emotionType);
        return ResponseEntity.ok(savedEmotionType);
    }
}