package ru.digdes.steammarketparser.service;

import ru.digdes.steammarketparser.model.entity.Item;

/**
 * TODO javadoc
 */
public interface ItemService {
    Iterable<Item> findAll();
}
