package ru.digdes.steammarketparser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.digdes.steammarketparser.dto.PriceDTO;
import ru.digdes.steammarketparser.model.entity.Price;
import ru.digdes.steammarketparser.service.PriceService;

@RestController
public class PriceController {
    @Qualifier("priceServiceImpl")
    @Autowired
    private PriceService priceService;

    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    public Iterable<PriceDTO> allPrices() {
        return priceService.getAllInDTOFormat();
    }
}
