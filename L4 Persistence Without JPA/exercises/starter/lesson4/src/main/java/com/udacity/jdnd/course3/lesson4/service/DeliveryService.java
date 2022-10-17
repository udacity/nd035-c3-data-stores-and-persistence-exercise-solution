package com.udacity.jdnd.course3.lesson4.service;

import com.udacity.jdnd.course3.lesson4.data.delivery.Delivery;
import com.udacity.jdnd.course3.lesson4.data.delivery.DeliveryRepository;
import com.udacity.jdnd.course3.lesson4.data.delivery.RecipientAndPrice;
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
