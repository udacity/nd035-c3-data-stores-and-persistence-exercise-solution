package com.udacity.jdnd.course3.lesson4.controller;

import com.udacity.jdnd.course3.lesson4.data.candy.CandyDAO;
import com.udacity.jdnd.course3.lesson4.data.candy.CandyData;
import com.udacity.jdnd.course3.lesson4.data.delivery.Delivery;
import com.udacity.jdnd.course3.lesson4.data.delivery.RecipientAndPrice;
import com.udacity.jdnd.course3.lesson4.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @Autowired
    CandyDAO candyDAO;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId) {
        return deliveryService.getBill(deliveryId);
    }

    @GetMapping("/candy")
    public List<CandyData> seeAvailableCandy(){
        return candyDAO.list();
    }

    @GetMapping("/candy/{deliveryId}")
    public List<CandyData> findByDelivery(@PathVariable Long deliveryId) {
        return candyDAO.findByDelivery(deliveryId);
    }

    @PostMapping("/candy/{deliveryId}/{candyId}")
    public void addCandy(@PathVariable Long deliveryId, @PathVariable Long candyId) {
        candyDAO.addToDelivery(candyId, deliveryId);
    }
}
