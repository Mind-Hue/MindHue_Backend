package com.mindhue.mindhue.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "emotion_types")
public class EmotionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String colorHex;

    @OneToMany(mappedBy = "emotionTypeId", cascade = CascadeType.ALL)
    private List<EmotionLog> emotionLogs;

    public EmotionType() {}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorHex() {
        return this.colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public List<EmotionLog> getEmotionLogs() {
        return this.emotionLogs;
    }

    public void setEmotionLogs(List<EmotionLog> emotionLogs) {
        this.emotionLogs = emotionLogs;
    }

}