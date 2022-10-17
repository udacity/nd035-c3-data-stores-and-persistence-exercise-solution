package com.udacity.jdnd.course3.exercise1.service;

import com.udacity.jdnd.course3.exercise1.data.OutfitRepository;
import com.udacity.jdnd.course3.exercise1.entities.Outfit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutfitService {

    @Autowired
    OutfitRepository outfitRepository;

    public void eatOutfit(Outfit outfit){
        outfitRepository.save(outfit);
    }

    public Outfit expelOutfit(Long id){
        return outfitRepository.findById(id).get();
    }
}
