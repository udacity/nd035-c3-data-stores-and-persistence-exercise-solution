package com.udacity.jdnd.course3.exercise4.data;

import java.util.List;

public class PersonWithOutfit {
    private String name;
    private int age;
    private String favoriteComposer;
    private List<OutfitData> outfits;

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

    public List<OutfitData> getOutfits() {
        return outfits;
    }

    public void setOutfits(List<OutfitData> outfits) {
        this.outfits = outfits;
    }
}
