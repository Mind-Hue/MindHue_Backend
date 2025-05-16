package com.mindhue.mindhue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindhue.mindhue.model.Emotion;

@Repository
public interface EmotionRepository extends JpaRepository<Emotion,Integer> {}