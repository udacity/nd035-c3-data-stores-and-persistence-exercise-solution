package com.udacity.jdnd.course3.exercise1.controller;

import com.udacity.jdnd.course3.exercise1.entities.Outfit;
import com.udacity.jdnd.course3.exercise1.service.OutfitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/outfit")
public class OutfitController {

    @Autowired
    OutfitService outfitService;

    @GetMapping("/{outfitId}")
    public Outfit getOutfit(@PathVariable Long outfitId){
        return outfitService.expelOutfit(outfitId);
    }

    @PostMapping
    public void consumeOutfit(@RequestBody Outfit outfit) {
        outfitService.eatOutfit(outfit);
    }

    private static OutfitDTO convertEntityToOutfitDTO(Outfit outfit){
        OutfitDTO outfitDTO = new OutfitDTO();
        BeanUtils.copyProperties(outfit, outfitDTO);
        return outfitDTO;
    }

    private static Outfit convertOutfitDTOToEntity(OutfitDTO outfitDTO){
        Outfit outfit = new Outfit();
        BeanUtils.copyProperties(outfitDTO, outfit);
        return outfit;
    }
}
