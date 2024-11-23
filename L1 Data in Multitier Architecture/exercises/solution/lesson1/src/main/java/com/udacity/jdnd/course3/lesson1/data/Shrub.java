package com.udacity.jdnd.course3.lesson1.data;

import jakarta.persistence.Entity;

@Entity
public class Shrub extends Plant {
    private int heightCm; //any reasonable unit of measurement is fine
    private int widthCm;
    /* getters and setters*/
}
