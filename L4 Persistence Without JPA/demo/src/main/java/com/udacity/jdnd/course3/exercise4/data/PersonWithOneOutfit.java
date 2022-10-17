package com.udacity.jdnd.course3.exercise4.data;

public class PersonWithOneOutfit {
    private String name;
    private int age;
    private String favoriteComposer;
    private OutfitData outfit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteComposer() {
        return favoriteComposer;
    }

    public void setFavoriteComposer(String favoriteComposer) {
        this.favoriteComposer = favoriteComposer;
    }

    public OutfitData getOutfit() {
        return outfit;
    }

    public void setOutfit(OutfitData outfit) {
        this.outfit = outfit;
    }
}
