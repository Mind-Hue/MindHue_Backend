package com.mindhue.mindhue.service;

import com.mindhue.mindhue.model.Exercise;
import com.mindhue.mindhue.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getExercisesByEmotion(int emotionTypeId) {
        return exerciseRepository.findByEmotionTypeId(emotionTypeId);
    }
}