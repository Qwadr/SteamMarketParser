package ru.digdes.steammarketparser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.digdes.steammarketparser.model.entity.ItemTracking;
import ru.digdes.steammarketparser.service.ItemTrackingService;

@RestController
public class ItemTrackingController {
    @Qualifier("itemTrackingServiceImpl")
    @Autowired
    private ItemTrackingService itemTrackingService;

    @RequestMapping(value = "/itemtracking", method = RequestMethod.GET)
    public Iterable<ItemTracking> allItemTracking() {
        return itemTrackingService.findAll();
    }
}
