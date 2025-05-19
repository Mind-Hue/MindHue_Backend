package com.mindhue.mindhue.repository;

import com.mindhue.mindhue.model.EmotionLog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionLogRepository extends JpaRepository<EmotionLog, Integer> {
    List<EmotionLog> findByUserName(String userName); // Buscar por nombre de usuario
}