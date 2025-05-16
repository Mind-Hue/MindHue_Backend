package com.mindhue.mindhue.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindhue.mindhue.model.Emotion;
import com.mindhue.mindhue.repository.EmotionRepository;

import java.util.Optional;

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

    public ResponseEntity<Object> getAllEmotions() {
        return new ResponseEntity<>(emotionRepository.findAll(), HttpStatus.OK);
    } 

    public Optional<Emotion> getEmotionById(int id) {
        return emotionRepository.findById(id);
    }

    public ResponseEntity<Object> updateEmotion(int id, Emotion emotion) {
        Optional<Emotion> existingEmotion = emotionRepository.findById(id);
        if (existingEmotion.isPresent()) {
            emotion.setId(id);
            emotionRepository.save(emotion);
            return new ResponseEntity<>(emotion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Emotion not found", HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Object> deleteEmotion(int id) {
        Optional<Emotion> existingEmotion = emotionRepository.findById(id);
        if (existingEmotion.isPresent()) {
            emotionRepository.deleteById(id);
            return new ResponseEntity<>("Emotion deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Emotion not found", HttpStatus.NOT_FOUND);
        }
    }

   
}
