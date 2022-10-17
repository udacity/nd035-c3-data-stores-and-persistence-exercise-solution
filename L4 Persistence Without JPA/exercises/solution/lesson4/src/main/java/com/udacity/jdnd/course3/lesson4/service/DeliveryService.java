package com.udacity.jdnd.course3.lesson4.service;

import com.udacity.jdnd.course3.lesson4.data.candy.CandyDAO;
import com.udacity.jdnd.course3.lesson4.data.candy.CandyData;
import com.udacity.jdnd.course3.lesson4.data.delivery.Delivery;
import com.udacity.jdnd.course3.lesson4.data.delivery.DeliveryRepository;
import com.udacity.jdnd.course3.lesson4.data.delivery.RecipientAndPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    CandyDAO candyDAO;

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }

    public Long save(Delivery delivery) {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public List<CandyData> seeAvailableCandy(){
        return candyDAO.list();
    }

    public void addCandy(Long candyId, Long deliveryId) {
        candyDAO.addToDelivery(candyId, deliveryId);
    }

    public List<CandyData> getCandy(Long deliveryId){
        return candyDAO.findByDelivery(deliveryId);
    }
}
