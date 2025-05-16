package com.mindhue.mindhue.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mindhue.mindhue.model.EmotionType;
import com.mindhue.mindhue.service.EmotionTypeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/mindhue")
public class EmotionTypeController {

    private final EmotionTypeService emotionService;

    public EmotionTypeController(EmotionTypeService emotionService) {
        this.emotionService = emotionService;
    }
    @PostMapping("/emotions")
    public ResponseEntity<Object> createEmotionType(@Valid @RequestBody EmotionType emotion) {
        emotionService.createEmotionType(emotion);
        return emotionService.createEmotionType(emotion);
    }
    @GetMapping("/emotions/all")
    public ResponseEntity<Object> getAllEmotionTypes() {
        return emotionService.getAllEmotionTypes();
    }
    @GetMapping("/emotions/{id}")
    public Optional<EmotionType> getEmotionTypeById(@PathVariable int id) {
        return emotionService.getEmotionTypeById(id);
    }
    @PutMapping("/emotions/update/{id}")
    public ResponseEntity<Object> updateEmotionType(@PathVariable int id,@Valid @RequestBody EmotionType emotion) {
        return emotionService.updateEmotionType(id, emotion);
    }
    @DeleteMapping("/emotions/delete/{id}")
    public ResponseEntity<Object> deleteEmotionType(@PathVariable int id) {
        return emotionService.deleteEmotionType(id);
    }
}
