package com.mindHue.mindHue.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.mindHue.mindHue.model.Emotion;
import com.mindHue.mindHue.service.EmotionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/v1/mindHue")
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
