package com.mindhue.mindhue.controller;

import com.mindhue.mindhue.model.Exercise;
import com.mindhue.mindhue.service.ExerciseService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/emotion/{emotionTypeId}")
    public List<Exercise> getExercisesByEmotion(@PathVariable int emotionTypeId) {
        return exerciseService.getExercisesByEmotion(emotionTypeId);
    }
}