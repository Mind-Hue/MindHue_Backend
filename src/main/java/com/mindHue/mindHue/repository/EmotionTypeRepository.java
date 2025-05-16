package com.mindhue.mindhue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindhue.mindhue.model.EmotionType;

@Repository
public interface EmotionTypeRepository extends JpaRepository<EmotionType,Integer> {}