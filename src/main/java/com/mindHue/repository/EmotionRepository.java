package com.mindHue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mindHue.mindHue.model.Emotion;

public interface EmotionRepository extends JpaRepository<Emotion,Integer> {}