package com.udacity.jdnd.course3.lesson4.controller;

import com.udacity.jdnd.course3.lesson4.data.delivery.Delivery;
import com.udacity.jdnd.course3.lesson4.data.delivery.RecipientAndPrice;
import com.udacity.jdnd.course3.lesson4.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery) {
        return deliveryService.save(delivery);
    }

    @GetMapping("/bill/{deliveryId}")
    public RecipientAndPrice getBill(@PathVariable Long deliveryId) {
        return deliveryService.getBill(deliveryId);
    }
}
