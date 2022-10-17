package com.udacity.jdnd.course3.exercise1.data;

import com.udacity.jdnd.course3.exercise1.entities.Outfit;
import org.springframework.data.repository.CrudRepository;

public interface OutfitRepository extends CrudRepository<Outfit, Long> {
    Outfit findByHat(String hat);
    Outfit findByHatAndShoes(String hat, String shoes);
}
