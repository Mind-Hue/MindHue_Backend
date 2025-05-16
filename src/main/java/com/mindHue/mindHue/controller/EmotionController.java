package com.mindhue.mindhue.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mindhue.mindhue.model.Emotion;
import com.mindhue.mindhue.service.EmotionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/mindhue")
public class EmotionController {

    private final EmotionService emotionService;

    public EmotionController(EmotionService emotionService) {
        this.emotionService = emotionService;
    @PostMapping("/emotions")
    public ResponseEntity<Object> createEmotion(@RequestBody Emotion emotion) {
        emotionService.createEmotion(emotion);
        return emotionService.createEmotion(emotion);
    }
    @GetMapping("/emotions/all")
    public ResponseEntity<Object> getAllEmotions() {
        return emotionService.getAllEmotions();
    }
    @GetMapping("/emotions/{id}")
    public Optional<Emotion> getEmotionById(@PathVariable int id) {
        return emotionService.getEmotionById(id);
    }
    @PutMapping("/emotions/update/{id}")
    public ResponseEntity<Object> updateEmotion(@PathVariable int id, @RequestBody Emotion emotion) {
        return emotionService.updateEmotion(id, emotion);
    }
    @DeleteMapping("/emotions/delete/{id}")
    public ResponseEntity<Object> deleteEmotion(@PathVariable int id) {
        return emotionService.deleteEmotion(id);
    }
}
