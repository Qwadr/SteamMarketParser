package ru.digdes.steammarketparser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.service.ItemService;

@RestController
public class ItemController {
    @Qualifier("itemServiceImpl")
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public Iterable<Item> allItems() {
        return itemService.findAll();
    }
}
