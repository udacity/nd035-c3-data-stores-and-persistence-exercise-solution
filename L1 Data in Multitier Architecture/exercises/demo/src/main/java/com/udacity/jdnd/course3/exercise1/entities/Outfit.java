package com.udacity.jdnd.course3.exercise1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Outfit {
    @Id
    @GeneratedValue
    private Long id;

    private String hat;
    private String gloves;
    private String shoes;
    private String legs;
    private String top;

    @ManyToOne
    private Humanoid humanoid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHat() {
        return hat;
    }

    public void setHat(String hat) {
        this.hat = hat;
    }

    public String getGloves() {
        return gloves;
    }

    public void setGloves(String gloves) {
        this.gloves = gloves;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public Humanoid getHumanoid() {
        return humanoid;
    }

    public void setHumanoid(Humanoid humanoid) {
        this.humanoid = humanoid;
    }
}
