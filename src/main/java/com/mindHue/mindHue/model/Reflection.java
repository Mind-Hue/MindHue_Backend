package com.mindhue.mindhue.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "reflections")
public class Reflection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "EmotionLogId cannot be null")
    private int emotionLogId;

    @ElementCollection
    @NotEmpty(message = "Answers cannot be empty")
    private List<String> answers;

    private String extraNote;

    public Reflection() {}


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmotionLogId() {
        return this.emotionLogId;
    }

    public void setEmotionLogId(int emotionLogId) {
        this.emotionLogId = emotionLogId;
    }

    public List<String> getAnswers() {
        return this.answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getExtraNote() {
        return this.extraNote;
    }

    public void setExtraNote(String extraNote) {
        this.extraNote = extraNote;
    }

}