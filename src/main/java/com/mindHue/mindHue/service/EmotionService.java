package com.mindHue.mindHue.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.mindHue.repository.EmotionRepository;
import com.mindHue.mindHue.model.Emotion;

import org.springframework.http.HttpStatus;



@Service  
public class EmotionService {
    
    private final EmotionRepository emotionRepository;

    public EmotionService(EmotionRepository emotionRepository) {
        this.emotionRepository = emotionRepository;
    }

    public ResponseEntity <Object> createEmotion(Emotion emotion){
        emotionRepository.save(emotion);
        return new ResponseEntity<>(emotion,HttpStatus.CREATED);
    }

}
