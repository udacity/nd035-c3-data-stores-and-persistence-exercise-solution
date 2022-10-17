package com.udacity.jdnd.course3.lesson2.service;

import com.udacity.jdnd.course3.lesson2.data.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    public Plant getPlantByName(String name){
        return new Plant();
    }
}
