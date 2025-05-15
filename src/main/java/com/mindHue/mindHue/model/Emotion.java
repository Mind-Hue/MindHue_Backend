package com.mindHue.mindHue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "emotions")
public class Emotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int colorHex;
    private String exercise1;
    private String exercise2;


    public Emotion() {}


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColorHex() {
        return this.colorHex;
    }

    public void setColorHex(int colorHex) {
        this.colorHex = colorHex;
    }

    public String getExercise1() {
        return this.exercise1;
    }

    public void setExercise1(String exercise1) {
        this.exercise1 = exercise1;
    }

    public String getExercise2() {
        return this.exercise2;
    }

    public void setExercise2(String exercise2) {
        this.exercise2 = exercise2;
    }


}

   