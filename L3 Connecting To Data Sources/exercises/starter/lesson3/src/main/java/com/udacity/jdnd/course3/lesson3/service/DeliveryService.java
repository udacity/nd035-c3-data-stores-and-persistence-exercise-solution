package com.udacity.jdnd.course3.lesson3.service;

import com.udacity.jdnd.course3.lesson3.data.Delivery;
import com.udacity.jdnd.course3.lesson3.data.DeliveryRepository;
import com.udacity.jdnd.course3.lesson3.data.RecipientAndPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }
}
