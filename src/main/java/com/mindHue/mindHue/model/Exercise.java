package com.mindhue.mindhue.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int emotionTypeId;
    private String name;
    private String instructions;
    private String materials;
    private int estimatedTime;

    @OneToMany(mappedBy = "exerciseId", cascade = CascadeType.ALL)
    private List<EmotionLog> emotionLogs;

    public Exercise() {}


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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getMaterials() {
        return this.materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public int getEstimatedTime() {
        return this.estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public List<EmotionLog> getEmotionLogs() {
        return this.emotionLogs;
    }

    public void setEmotionLogs(List<EmotionLog> emotionLogs) {
        this.emotionLogs = emotionLogs;
    }

}