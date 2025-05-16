package com.mindhue.mindhue.repository;

import com.mindhue.mindhue.model.EmotionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionLogRepository extends JpaRepository<EmotionLog, Integer> {
}