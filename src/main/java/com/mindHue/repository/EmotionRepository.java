package com.mindHue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindHue.mindHue.model.Emotion;

@Repository
public interface EmotionRepository extends JpaRepository<Emotion,Integer> {}