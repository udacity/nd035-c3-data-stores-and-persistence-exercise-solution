package com.udacity.jdnd.course3.lesson3.data;

import javax.persistence.Entity;

@Entity
public class Shrub extends Plant {
    private int heightCm; //any reasonable unit of measurement is fine
    private int widthCm;

    public int getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(int heightCm) {
        this.heightCm = heightCm;
    }

    public int getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(int widthCm) {
        this.widthCm = widthCm;
    }
}
