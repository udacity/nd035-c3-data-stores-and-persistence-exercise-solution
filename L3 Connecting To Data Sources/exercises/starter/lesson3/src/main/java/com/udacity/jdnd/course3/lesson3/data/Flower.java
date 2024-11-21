package com.udacity.jdnd.course3.lesson3.data;

import jakarta.persistence.Entity;

@Entity
public class Flower extends Plant {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
