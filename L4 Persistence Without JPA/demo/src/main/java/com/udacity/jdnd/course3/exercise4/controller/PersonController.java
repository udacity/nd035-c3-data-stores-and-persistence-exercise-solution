package com.udacity.jdnd.course3.exercise4.controller;

import com.udacity.jdnd.course3.exercise4.data.OutfitData;
import com.udacity.jdnd.course3.exercise4.data.PersonData;
import com.udacity.jdnd.course3.exercise4.data.PersonWithAllOutfits;
import com.udacity.jdnd.course3.exercise4.data.PersonWithOneOutfit;
import com.udacity.jdnd.course3.exercise4.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{personId}")
    PersonData getPerson(@PathVariable Long personId) {
        return personService.getPerson(personId);
    }

    @PostMapping
    PersonData addPerson(@RequestBody PersonData personData){
        return personService.addPerson(personData);
    }

    @PostMapping("/{personId}/outfit")
    PersonWithOneOutfit addOutfitForPerson(@PathVariable Long personId, @RequestBody OutfitData outfitData) {
        return personService.addOutfitForPerson(personId, outfitData);
    }

    @PostMapping("/{personId}/outfit/all")
    PersonWithAllOutfits addOutfitForPersonAll(@PathVariable Long personId, @RequestBody OutfitData outfitData) {
        return personService.addOutfitForPersonAll(personId, outfitData);
    }

}
