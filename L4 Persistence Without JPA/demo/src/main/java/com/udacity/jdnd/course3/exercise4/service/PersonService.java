package com.udacity.jdnd.course3.exercise4.service;

import com.udacity.jdnd.course3.exercise4.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    public PersonData addPerson(PersonData personData) {
        Long newId = personDAO.addPersonInsert(personData);
        personData.setId(newId);
        return personData;
    }

    public PersonWithOneOutfit addOutfitForPerson(Long personId, OutfitData outfitData){
        return personDAO.addOutfitForPerson(personId, outfitData);
    }

    public PersonWithAllOutfits addOutfitForPersonAll(Long personId, OutfitData outfitData) {
        return personDAO.addOutFitForPersonReturnAllFancy(personId, outfitData);
    }

    public PersonData getPerson(Long personId) {
        return personDAO.getPersonById(personId);
    }
}
