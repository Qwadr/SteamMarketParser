package ru.digdes.steammarketparser.service;

import ru.digdes.steammarketparser.dto.PriceDTO;
import ru.digdes.steammarketparser.model.entity.Price;

/**
 * TODO javadoc
 */
public interface PriceService {
    Iterable<Price> findAll();

    Iterable<PriceDTO> getAllInDTOFormat();
}
