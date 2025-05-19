package com.mindhue.mindhue.repository;

import com.mindhue.mindhue.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    List<Exercise> findByEmotionTypeId(int emotionTypeId);
}