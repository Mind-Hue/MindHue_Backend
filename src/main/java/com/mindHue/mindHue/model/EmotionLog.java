package com.mindhue.mindhue.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "emotion_logs")
public class EmotionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "EmotionTypeId cannot be null")
    private int emotionTypeId;

    @NotNull(message = "ExerciseId cannot be null")
    private int exerciseId;

    @NotNull(message = "Intensity cannot be null")
    @Min(value = 1, message = "Intensity must be at least 1")
    @Max(value = 5, message = "Intensity must not exceed 5")
    private int intensity;

    @NotNull(message = "UserName cannot be null")
    private String userName;

    @NotNull(message = "CreatedAt cannot be null")
    private LocalDateTime createdAt;

    public EmotionLog() {
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmotionTypeId() {
        return this.emotionTypeId;
    }

    public void setEmotionTypeId(int emotionTypeId) {
        this.emotionTypeId = emotionTypeId;
    }

    public int getExerciseId() {
        return this.exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getIntensity() {
        return this.intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // Getters y setters
}