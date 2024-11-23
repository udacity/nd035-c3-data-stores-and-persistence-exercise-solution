package com.udacity.jdnd.course3.exercise1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CreepyDepartmentStoreMannequin extends Humanoid {

    private boolean hasAHead;
    private MannequinShape mannequinShape;

    enum MannequinShape {
        LITHE, MUSCULUR, TERRY;
    }

    public boolean isHasAHead() {
        return hasAHead;
    }

    public void setHasAHead(boolean hasAHead) {
        this.hasAHead = hasAHead;
    }

    public MannequinShape getMannequinShape() {
        return mannequinShape;
    }

    public void setMannequinShape(MannequinShape mannequinShape) {
        this.mannequinShape = mannequinShape;
    }
}

