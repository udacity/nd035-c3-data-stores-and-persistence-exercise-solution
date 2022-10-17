package com.udacity.jdnd.course3.exercise1.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "Humanoid.findAllNamedQuery", query="select h from Humanoid h where :outfit member of h.outfits")
public class Humanoid {
    @Id
    @GeneratedValue
    Long id;

    @OneToMany(mappedBy="humanoid")
    List<Outfit> outfits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Outfit> getOutfits() {
        return outfits;
    }

    public void setOutfits(List<Outfit> outfits) {
        this.outfits = outfits;
    }
}
