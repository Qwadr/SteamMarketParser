package ru.digdes.steammarketparser.service;

import ru.digdes.steammarketparser.model.entity.Price;

/**
 * TODO javadoc
 */
public interface PriceParser {
    Price parse(String jsonText);
}
