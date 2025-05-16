package com.mindhue.mindhue.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mindhue.mindhue.model.Emotion;
import com.mindhue.mindhue.service.EmotionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/mindhue")
public class EmotionController {

    private final EmotionService emotionService;

    public EmotionController(EmotionService emotionService) {
        this.emotionService = emotionService;
    }

    @PostMapping("/emotions")
    public ResponseEntity<Object> createEmotion(@RequestBody Emotion emotion) {
        emotionService.createEmotion(emotion);
        return emotionService.createEmotion(emotion);
    }
}
