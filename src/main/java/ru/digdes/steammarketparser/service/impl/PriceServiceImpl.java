package ru.digdes.steammarketparser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digdes.steammarketparser.dto.PriceDTO;
import ru.digdes.steammarketparser.model.entity.Price;
import ru.digdes.steammarketparser.model.repository.PriceRepository;
import ru.digdes.steammarketparser.service.PriceService;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO javadoc
 */
@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Iterable<Price> findAll() {
        return priceRepository.findAll();
    }

    @Override
    public Iterable<PriceDTO> getAllInDTOFormat() {
        Iterable<Price> allPrices = priceRepository.findAll();
        List<PriceDTO> allPricesInDTOFormat = new ArrayList<>();

        for (Price price : allPrices) {
            allPricesInDTOFormat.add(new PriceDTO(price));
        }

        return allPricesInDTOFormat;
    }
}
