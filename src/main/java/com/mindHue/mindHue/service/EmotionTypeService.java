package com.mindhue.mindhue.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindhue.mindhue.model.EmotionType;
import com.mindhue.mindhue.repository.EmotionTypeRepository;

import java.util.Optional;

import org.springframework.http.HttpStatus;



@Service  
public class EmotionTypeService {
    
    private final EmotionTypeRepository EmotionTypeRepository;

    public EmotionTypeService(EmotionTypeRepository EmotionTypeRepository) {
        this.EmotionTypeRepository = EmotionTypeRepository;
    }

    public ResponseEntity <Object> createEmotionType(EmotionType EmotionType){
        EmotionTypeRepository.save(EmotionType);
        return new ResponseEntity<>(EmotionType,HttpStatus.CREATED);
    }

    public ResponseEntity<Object> getAllEmotionTypes() {
        return new ResponseEntity<>(EmotionTypeRepository.findAll(), HttpStatus.OK);
    } 

    public Optional<EmotionType> getEmotionTypeById(int id) {
        return EmotionTypeRepository.findById(id);
    }

    public ResponseEntity<Object> updateEmotionType(int id, EmotionType EmotionType) {
        Optional<EmotionType> existingEmotionType = EmotionTypeRepository.findById(id);
        if (existingEmotionType.isPresent()) {
            EmotionType.setId(id);
            EmotionTypeRepository.save(EmotionType);
            return new ResponseEntity<>(EmotionType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("EmotionType not found", HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Object> deleteEmotionType(int id) {
        Optional<EmotionType> existingEmotionType = EmotionTypeRepository.findById(id);
        if (existingEmotionType.isPresent()) {
            EmotionTypeRepository.deleteById(id);
            return new ResponseEntity<>("EmotionType deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("EmotionType not found", HttpStatus.NOT_FOUND);
        }
    }

   
}
